package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import answers.Film;
import bot.Attitude;
import bot.InputData;

class FilmTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		Film film = new Film();
		String answer = film.getAnswerData(new InputData(a, null, null)).getAnswer();
		assertTrue(Arrays.asList(Film.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		Film film = new Film();
		String answer = film.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Film.neutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		Film film = new Film();
		String answer = film.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Film.cheerfulAnswers).contains(arrAnswers[0]));
	}

	@Test
	void filmTest() {
		Attitude a = new Attitude();
		Film film = new Film();
		String answer = film.getAnswerData(new InputData(a, null, null)).getAnswer();
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(Film.films).contains(arrAnswers[1]));
	}

}
