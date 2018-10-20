package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import answers.Hello;

import bot.Attitude;
import bot.InputData;

class HelloTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		Hello hello = new Hello();
		String answer = hello.getAnswerData(new InputData(a,null,null)).getAnswer();
		assertTrue(Arrays.asList(Hello.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		Hello hello = new Hello();
		String answer = hello.getAnswerData(new InputData(a,null,null)).getAnswer();
		assertTrue(Arrays.asList(Hello.neutralAnswers).contains(answer));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		Hello hello = new Hello();
		String answer = hello.getAnswerData(new InputData(a,null,null)).getAnswer();
		assertTrue(Arrays.asList(Hello.cheerfulAnswers).contains(answer));
	}

}
