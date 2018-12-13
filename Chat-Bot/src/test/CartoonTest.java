package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import answers.Cartoon;
import bot.Attitude;
import bot.InputData;

class CartoonTest {
	@Test
	void cartoonTest() {
		Attitude a = new Attitude();
		Cartoon cartoon = new Cartoon();
		String answer = cartoon.getAnswerData(new InputData(a, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(new Cartoon().cartoons).contains(arrAnswers[1]));
	}

}
