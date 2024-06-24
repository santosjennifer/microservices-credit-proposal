package com.github.creditanalysis.service.strategy.impl;

import org.springframework.stereotype.Component;

import com.github.creditanalysis.domain.Proposal;
import com.github.creditanalysis.service.strategy.ScoreCalculation;

@Component
public class IncomeHighestValueRequestedImpl implements ScoreCalculation {

	@Override
	public int calculate(Proposal proposal) {
		return incomeHighestValueRequested(proposal) ? 100 : 0;
	}
	
	private boolean incomeHighestValueRequested(Proposal proposal) {
		return proposal.getUser().getIncome() > proposal.getValueRequested();
	}

}
