package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import answers.Series;
import bot.Attitude;
import bot.InputData;

class SeriesTest {
	@Test
	void seriesTest() {
		Attitude a = new Attitude();
		Series series = new Series();
		String answer = series.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Series.series).contains(arrAnswers[1]));
	}
}
