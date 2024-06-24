package com.github.creditanalysis.service.strategy.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.github.creditanalysis.domain.Proposal;
import com.github.creditanalysis.service.strategy.ScoreCalculation;

@Component
public class OtherLoansInProgressImpl implements ScoreCalculation {

	@Override
	public int calculate(Proposal proposal) {
		return otherLoansInProgress() ? 0 : 80; 
	}
	
	private boolean otherLoansInProgress() {
		return new Random().nextBoolean();
	}

}
