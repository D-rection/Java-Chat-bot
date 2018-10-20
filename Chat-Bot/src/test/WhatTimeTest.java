package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;

import answers.WhatTime;
import bot.Attitude;
import bot.InputData;

class WhatTimeTest {

	@Test
	void attitudeAngryTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.decreaseFriendliness();
		WhatTime whattime = new WhatTime();
		String answer = whattime.getAnswerData(new InputData(a, null, null)).getAnswer();
		assertTrue(Arrays.asList(WhatTime.angryAnswers).contains(answer));
	}

	@Test
	void attitudeNeutralTest() {
		Attitude a = new Attitude();
		WhatTime whattime = new WhatTime();
		String answer = whattime.getAnswerData(new InputData(a, null, null)).getAnswer();
		Date date = new Date();
		assertTrue(answer.equals(new SimpleDateFormat("'Сейчас' kk:mm").format(date)));
	}

	@Test
	void attitudeCheerfulTest() {
		Attitude a = new Attitude();
		for (int i = 0; i < 5; i++)
			a.increasedFriendliness();
		WhatTime whattime = new WhatTime();
		String answer = whattime.getAnswerData(new InputData(a, null, null)).getAnswer();
		Date date = new Date();
		assertTrue(answer.equals(new SimpleDateFormat("'Сейчас' kk:mm").format(date)));
	}

}
