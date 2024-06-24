package com.github.notification.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.github.notification.constant.ConstantMessage;
import com.github.notification.domain.Proposal;
import com.github.notification.service.NotificationSnsService;

@Component
public class ProposalPendingListener {
	
	private NotificationSnsService service;
	
	public ProposalPendingListener(NotificationSnsService service) {
		this.service = service;
	}
	
	private final Logger log = LoggerFactory.getLogger(ProposalPendingListener.class);

	@RabbitListener(queues = "${rabbitmq.queue.proposal.pending}")
	public void proposalPending(Proposal proposal) {
		String message = String.format(ConstantMessage.PROPOSAL_IN_ANALYSIS, proposal.getUser().getFirstname());
		service.notify(proposal.getUser().getPhone(), message);
		log.info("Notificação de proposta pendente. Mensagem: {}", message);
	}

}
