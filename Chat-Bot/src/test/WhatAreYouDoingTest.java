package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.WhatAreYouDoing;
import bot.Attitude;
import bot.InputData;

class WhatAreYouDoingTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		WhatAreYouDoing whatAreYouDoing = new WhatAreYouDoing();
		String answer = whatAreYouDoing.getAnswerData(new InputData(a, null, null)).getAnswer();
		assertTrue(Arrays.asList(WhatAreYouDoing.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		WhatAreYouDoing whatAreYouDoing = new WhatAreYouDoing();
		String answer = whatAreYouDoing.getAnswerData(new InputData(a, null, null)).getAnswer();
		assertTrue(Arrays.asList(WhatAreYouDoing.neutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		WhatAreYouDoing whatAreYouDoing = new WhatAreYouDoing();
		String answer = whatAreYouDoing.getAnswerData(new InputData(a, null, null)).getAnswer();
		assertTrue(Arrays.asList(WhatAreYouDoing.cheerfulAnswers).contains(answer));
	}

}
