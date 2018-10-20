package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import answers.Series;
import bot.Attitude;
import bot.InputData;

class SeriesTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		Series series = new Series();
		String answer = series.getAnswerData(new InputData(a, null, null)).getAnswer();
		assertTrue(Arrays.asList(Series.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		Series series = new Series();
		String answer = series.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Series.neutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		Series series = new Series();
		String answer = series.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Series.cheerfulAnswers).contains(arrAnswers[0]));
	}

	@Test
	void seriesTest() {
		Attitude a = new Attitude();
		Series series = new Series();
		String answer = series.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Series.series).contains(arrAnswers[1]));
	}
}
