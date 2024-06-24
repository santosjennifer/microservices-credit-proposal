package com.github.creditanalysis.service.strategy.impl;

import java.util.Random;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.github.creditanalysis.constant.ConstantMessage;
import com.github.creditanalysis.domain.Proposal;
import com.github.creditanalysis.exception.StrategyException;
import com.github.creditanalysis.service.strategy.ScoreCalculation;

@Order(2)
@Component
public class SerasaScoreImpl implements ScoreCalculation {

	@Override
	public int calculate(Proposal proposal) {
		int score = score();

		if (score < 200) {
			throw new StrategyException(String.format(ConstantMessage.SCORE_SERASA_LOW, proposal.getUser().getFirstname()));
		} else if (score <= 400) {
			return 150;
		} else if (score <= 600) {
			return 180;
		} else {
			return 220;
		}
	}

	private int score() {
		return new Random().nextInt(0, 1000);
	}

}
