package com.github.proposalapp.scheduler;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.proposalapp.repository.ProposalRepository;
import com.github.proposalapp.service.NotificationService;

@Component
public class ProposalNotIntegrated {

	private final Logger log = LoggerFactory.getLogger(ProposalNotIntegrated.class);
	
	private final ProposalRepository proposalRepository;
	private final NotificationService notificationService;
	private final String exchange;

	public ProposalNotIntegrated(ProposalRepository proposalRepository, NotificationService notificationService,
			@Value("${rabbitmq.pendingproposal.exchange}") String exchange) {
		this.proposalRepository = proposalRepository;
		this.notificationService = notificationService;
		this.exchange = exchange;
	}

	@Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
	public void searchProposalNotIntegrated() {
		proposalRepository.findAllByIntegratedIsFalse().forEach(proposal -> {
			try {
				notificationService.notify(proposal, exchange);
				proposalRepository.updateStatusIntegrated(proposal.getId(), true);
				log.info("Proposta {} integrada com sucesso.", proposal.getId());
			} catch (RuntimeException ex) {
				log.error("Erro ao buscar propostas não integradas. " + ex.getMessage());
			}
		});
	}

}
