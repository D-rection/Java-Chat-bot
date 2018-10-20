package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import answers.Cartoon;
import bot.Attitude;
import bot.InputData;

class CartoonTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		Cartoon cartoon = new Cartoon();
		String answer = cartoon.getAnswerData(new InputData(a, null)).getAnswer();
		assertTrue(Arrays.asList(Cartoon.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		Cartoon cartoon = new Cartoon();
		String answer = cartoon.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Cartoon.neutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		Cartoon cartoon = new Cartoon();
		String answer = cartoon.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Cartoon.cheerfulAnswers).contains(arrAnswers[0]));
	}

	@Test
	void cartoonTest() {
		Attitude a = new Attitude();
		Cartoon cartoon = new Cartoon();
		String answer = cartoon.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Cartoon.cartoons).contains(arrAnswers[1]));
	}

}
