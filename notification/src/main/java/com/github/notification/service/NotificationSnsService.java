package com.github.notification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;

@Service
public class NotificationSnsService {
	
	private AmazonSNS amazonSNS;
	
	public NotificationSnsService(AmazonSNS amazonSNS) {
		this.amazonSNS = amazonSNS;
	}
	
	private final Logger log = LoggerFactory.getLogger(NotificationSnsService.class);

	public void notify(String phone, String message) {
		 PublishRequest request = new PublishRequest().withMessage(message).withPhoneNumber(phone);
		 log.info("Notificação enviada. Request: {}", request);
		 amazonSNS.publish(request);
	}
}
