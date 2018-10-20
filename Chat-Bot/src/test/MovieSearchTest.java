package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import bot.Attitude;

import answers.MovieSearch;

class MovieSearchTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		String answer = MovieSearch.getMovie(a, "cartoon");
		assertTrue(Arrays.asList(MovieSearch.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		String answer = MovieSearch.getMovie(a, "film");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.neutralAnswers).contains(arrAnswers[0]));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		String answer = MovieSearch.getMovie(a, "series");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.cheerfulAnswers).contains(arrAnswers[0]));
	}

	@Test
	void cartoonTest() {
		Attitude a = new Attitude();
		String answer = MovieSearch.getMovie(a, "cartoon");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.cartoons).contains(arrAnswers[1]));
	}

	@Test
	void filmTest() {
		Attitude a = new Attitude();
		String answer = MovieSearch.getMovie(a, "film");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.films).contains(arrAnswers[1]));
	}

	@Test
	void seriesTest() {
		Attitude a = new Attitude();
		String answer = MovieSearch.getMovie(a, "series");
		String[] arrAnswers = answer.split("\"");
		assertTrue(Arrays.asList(MovieSearch.series).contains(arrAnswers[1]));
	}
}
