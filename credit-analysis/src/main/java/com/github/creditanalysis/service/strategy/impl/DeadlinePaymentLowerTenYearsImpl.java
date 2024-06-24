package com.github.creditanalysis.service.strategy.impl;

import org.springframework.stereotype.Component;

import com.github.creditanalysis.domain.Proposal;
import com.github.creditanalysis.service.strategy.ScoreCalculation;

@Component
public class DeadlinePaymentLowerTenYearsImpl implements ScoreCalculation {

	@Override
	public int calculate(Proposal proposal) {
		return proposal.getDeadlinePayment() < 120 ? 80 : 0;
	}

}
