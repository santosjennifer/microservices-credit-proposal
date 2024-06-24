package com.github.proposalapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.proposalapp.dto.ProposalRequestDto;
import com.github.proposalapp.dto.ProposalResponseDto;
import com.github.proposalapp.exception.ProposalNotFoundException;
import com.github.proposalapp.mapper.ProposalMapper;
import com.github.proposalapp.model.Proposal;
import com.github.proposalapp.repository.ProposalRepository;

@Service
public class ProposalService {
	
	private ProposalRepository repository;
	private NotificationService notificationService;
	private String exchange;
	
    public ProposalService(ProposalRepository repository, NotificationService notificationService, 
    		@Value("${rabbitmq.pendingproposal.exchange}") String exchange) {
        this.repository = repository;
        this.notificationService = notificationService;
        this.exchange = exchange;
    }

    public ProposalResponseDto create(ProposalRequestDto requestDto) {
        Proposal proposal = ProposalMapper.INSTANCE.requestDtoToProposal(requestDto);
        repository.save(proposal);

        notifyRabbitMQ(proposal);

        return ProposalMapper.INSTANCE.proposalToResponseDto(proposal);
    }

    private void notifyRabbitMQ(Proposal proposal) {
        try {
        	notificationService.notify(proposal, exchange);
        } catch (RuntimeException ex) {
        	proposal.setIntegrated(false);
            repository.save(proposal);
        }
    }
	
	public List<ProposalResponseDto> findAll(){
		return ProposalMapper.INSTANCE.listProposalToListResponseDto(repository.findAll());
	}
	
	public ProposalResponseDto findById(Long id) {
		Optional<Proposal> proposal = repository.findById(id);
		
		if (proposal.isEmpty()) {
			throw new ProposalNotFoundException();
		}
		
		return ProposalMapper.INSTANCE.proposalToResponseDto(proposal.get());
	}
}
