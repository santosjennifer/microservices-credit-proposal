package com.github.creditanalysis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.creditanalysis.domain.Proposal;
import com.github.creditanalysis.exception.StrategyException;
import com.github.creditanalysis.service.strategy.ScoreCalculation;

@Service
public class CreditAnalysisService {
	 
	private final Logger log = LoggerFactory.getLogger(CreditAnalysisService.class);

	private List<ScoreCalculation> scoreCalculations;
	private NotificationService service;

	public CreditAnalysisService(List<ScoreCalculation> scoreCalculations, NotificationService service) {
		this.scoreCalculations = scoreCalculations;
		this.service = service;
	}
	
    @Value("${rabbitmq.completedproposal.exchange}")
    private String exchange;

    public void analysis(Proposal proposal) {
        try {
            int scores = scoreCalculations.stream().mapToInt(impl -> impl.calculate(proposal)).sum();
            proposal.setApproved(scores > 350);
            proposal.setObservation("Proposta aprovada. Pontuação " + scores);
            log.info("Proposta aprovada. Pontuação: {}.",scores);
        } catch (StrategyException ex) {
            proposal.setApproved(false);
            proposal.setObservation(ex.getMessage());
            log.info("Proposta reprovada. Mensagem: {}", ex.getMessage());
        }
        service.notify(exchange, proposal);
    }
}
