package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.WhatWatch;
import bot.Attitude;
import bot.InputData;

class WhatWatchTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		WhatWatch whatwatch = new WhatWatch();
		String answer = whatwatch.getAnswerData(new InputData(a, null)).getAnswer();
		assertTrue(Arrays.asList(new WhatWatch().angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		WhatWatch whatwatch = new WhatWatch();
		String answer = whatwatch.getAnswerData(new InputData(a, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(new WhatWatch().neutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		WhatWatch whatwatch = new WhatWatch();
		String answer = whatwatch.getAnswerData(new InputData(a, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(new WhatWatch().neutralAnswers).contains(arrAnswers[0]));
	}
}
