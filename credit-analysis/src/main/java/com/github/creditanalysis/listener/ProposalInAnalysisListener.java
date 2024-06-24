package com.github.creditanalysis.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.github.creditanalysis.domain.Proposal;
import com.github.creditanalysis.service.CreditAnalysisService;

@Configuration
public class ProposalInAnalysisListener {

    private final CreditAnalysisService service;

    public ProposalInAnalysisListener(CreditAnalysisService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposal.pending}")
    public void proposalInAnalysis(Proposal proposal) {
        service.analysis(proposal);
    }
}

