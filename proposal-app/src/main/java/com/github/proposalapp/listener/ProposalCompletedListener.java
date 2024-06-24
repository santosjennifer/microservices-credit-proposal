package com.github.proposalapp.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.github.proposalapp.mapper.ProposalMapper;
import com.github.proposalapp.model.Proposal;
import com.github.proposalapp.repository.ProposalRepository;
import com.github.proposalapp.service.WebSocketService;

@Component
public class ProposalCompletedListener {

	private ProposalRepository repository;

	private WebSocketService webSocketService;
	
	public ProposalCompletedListener(ProposalRepository repository, WebSocketService webSocketService) {
		this.repository = repository;
		this.webSocketService = webSocketService;
	}

	@RabbitListener(queues = "${rabbitmq.queue.proposal.completed}")
	public void proposalCompleted(Proposal proposal) {
		updateProposal(proposal);
		webSocketService.notify(ProposalMapper.INSTANCE.proposalToResponseDto(proposal));
	}

	private void updateProposal(Proposal proposal) {
		repository.updateProposal(proposal.getId(), proposal.isApproved(), proposal.getObservation());
	}

}
