package answers;

import java.text.SimpleDateFormat;
import java.util.Date;
import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;
import bot.Mood;

public class WhatDay implements TopicConversation {
	public static String[] angryAnswers = { "У тебя что телефона нет?", "В углу экрана посмотри" };

	public AnswerData getAnswerData(InputData input) {
		Date date = new Date();
		if (input.currentAttitude.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return new AnswerData(angryAnswers[random], false);
		} else {
			return new AnswerData(new SimpleDateFormat("'Сегодня' EE dd.MM.yyyy").format(date), false);
		}
	}
}
