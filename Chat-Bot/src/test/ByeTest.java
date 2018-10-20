package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.Bye;
import bot.Attitude;
import bot.InputData;

class ByeTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		Bye bye = new Bye();
		String answer = bye.getAnswerData(new InputData(a, null)).getAnswer();
		assertTrue(Arrays.asList(Bye.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		Bye bye = new Bye();
		String answer = bye.getAnswerData(new InputData(a, null)).getAnswer();
		assertTrue(Arrays.asList(Bye.neutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		Bye bye = new Bye();
		String answer = bye.getAnswerData(new InputData(a, null)).getAnswer();
		assertTrue(Arrays.asList(Bye.cheerfulAnswers).contains(answer));
	}
}
