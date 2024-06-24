package com.github.proposalapp.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.github.proposalapp.model.Proposal;

@Service
public class NotificationService {
	
    private RabbitTemplate rabbitTemplate;
    
    public NotificationService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

    public void notify(Proposal proposal, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", proposal);
    }

}
