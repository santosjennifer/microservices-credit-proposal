package com.github.creditanalysis.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.github.creditanalysis.domain.Proposal;

@Service
public class NotificationService {

	private RabbitTemplate template;

	public NotificationService(RabbitTemplate template) {
		this.template = template;
	}

	public void notify(String exchange, Proposal proposal) {
		template.convertAndSend(exchange, "", proposal);
	}
}
