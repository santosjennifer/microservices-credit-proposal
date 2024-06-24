package com.github.proposalapp.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.github.proposalapp.dto.ProposalResponseDto;

@Service
public class WebSocketService {

    private SimpMessagingTemplate template;
    
    public WebSocketService(SimpMessagingTemplate template) {
		this.template = template;
	}

    public void notify(ProposalResponseDto proposal) {
        template.convertAndSend("/proposals", proposal);
    }
    
}
