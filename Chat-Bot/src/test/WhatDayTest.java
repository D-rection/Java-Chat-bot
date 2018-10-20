package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;

import answers.WhatDay;
import bot.Attitude;
import bot.InputData;

class WhatDayTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		WhatDay whatday = new WhatDay();
		String answer = whatday.getAnswerData(new InputData(a, null, null)).getAnswer();
		assertTrue(Arrays.asList(WhatDay.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		WhatDay whatday = new WhatDay();
		String answer = whatday.getAnswerData(new InputData(a, null, null)).getAnswer();
		Date date = new Date();
		assertTrue(answer.equals(new SimpleDateFormat("'Сегодня' EE dd.MM.yyyy").format(date)));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		WhatDay whatday = new WhatDay();
		String answer = whatday.getAnswerData(new InputData(a, null, null)).getAnswer();
		Date date = new Date();
		assertTrue(answer.equals(new SimpleDateFormat("'Сегодня' EE dd.MM.yyyy").format(date)));
	}
}
