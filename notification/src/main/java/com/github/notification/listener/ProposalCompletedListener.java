package com.github.notification.listener;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.github.notification.constant.ConstantMessage;
import com.github.notification.domain.Proposal;
import com.github.notification.service.NotificationSnsService;

@Component
public class ProposalCompletedListener {

	private NotificationSnsService service;
	
	public ProposalCompletedListener(NotificationSnsService service) {
		this.service = service;
	}
	
	private final Logger log = LoggerFactory.getLogger(ProposalCompletedListener.class);

	@RabbitListener(queues = "${rabbitmq.queue.proposal.completed}")
	public void proposalCompleted(Proposal proposal) {
		String name = proposal.getUser().getFirstname();

		String message = proposal.isApproved() 
				? String.format(ConstantMessage.PROPOSAL_APPROVED, name) 
						: (Objects.nonNull(proposal.getObservation())
				? String.format(ConstantMessage.PROPOSAL_DENIED_FOR_STRATEGY, name, proposal.getObservation()) 
						: String.format(ConstantMessage.PROPOSAL_DENIED, name));

		service.notify(proposal.getUser().getPhone(), message);
		log.info("Notificação de proposta concluida. Mensagem: {}", message);
	}

}
