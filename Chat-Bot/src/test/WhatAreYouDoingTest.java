package test;

import static junit.framework.TestCase.assertTrue;
import java.util.Arrays;

import org.junit.Test;

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
		String answer = whatAreYouDoing.getAnswerData(new InputData(a, null)).getAnswer();
		assertTrue(Arrays.asList(new WhatAreYouDoing().angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		WhatAreYouDoing whatAreYouDoing = new WhatAreYouDoing();
		String answer = whatAreYouDoing.getAnswerData(new InputData(a, null)).getAnswer();
		assertTrue(Arrays.asList(new WhatAreYouDoing().neutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		WhatAreYouDoing whatAreYouDoing = new WhatAreYouDoing();
		String answer = whatAreYouDoing.getAnswerData(new InputData(a, null)).getAnswer();
		assertTrue(Arrays.asList(new WhatAreYouDoing().cheerfulAnswers).contains(answer));
	}

}
