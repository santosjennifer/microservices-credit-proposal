package com.github.creditanalysis.service.strategy;

import com.github.creditanalysis.domain.Proposal;

public interface ScoreCalculation {

	int calculate(Proposal proposal);
	
}
