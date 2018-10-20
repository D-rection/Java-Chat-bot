package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.HowAreYou;
import bot.Attitude;
import bot.InputData;

class HowAreYouTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		HowAreYou howAreYou = new HowAreYou();
		String answer = howAreYou.getAnswerData(new InputData(a,null,null)).getAnswer();
		assertTrue(Arrays.asList(HowAreYou.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		HowAreYou howAreYou = new HowAreYou();
		String answer = howAreYou.getAnswerData(new InputData(a,null,null)).getAnswer();
		assertTrue(Arrays.asList(HowAreYou.neutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		HowAreYou howAreYou = new HowAreYou();
		String answer = howAreYou.getAnswerData(new InputData(a,null,null)).getAnswer();
		assertTrue(Arrays.asList(HowAreYou.cheerfulAnswers).contains(answer));
	}

}
