package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import answers.Film;
import bot.Attitude;
import bot.InputData;

class FilmTest {
	@Test
	void filmTest() {
		Attitude a = new Attitude();
		Film film = new Film();
		String answer = film.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(new Film().films).contains(arrAnswers[1]));
	}

}
