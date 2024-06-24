package com.github.creditanalysis.service.strategy.impl;

import java.util.Random;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.creditanalysis.constant.ConstantMessage;
import com.github.creditanalysis.domain.Proposal;
import com.github.creditanalysis.exception.StrategyException;
import com.github.creditanalysis.service.strategy.ScoreCalculation;

@Order(1)
@Component
public class NameNegativeImpl implements ScoreCalculation {

	@Override
	public int calculate(Proposal proposal) {
		if (nameNegative()) {
			throw new StrategyException(String.format(ConstantMessage.CUSTOMER_NEGATIVE, proposal.getUser().getFirstname()));
		}
		return 100;
	}
	
	private boolean nameNegative() {
		return new Random().nextBoolean();
	}

}
