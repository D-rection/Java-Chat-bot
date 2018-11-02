package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;

public class WhatWatch extends BaseTopicConversation implements TopicConversation {
	public static String[] angryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
			"Давай как-нибудь сам" };
	public static String[] neutralAnswers = { "Что ты хочешь посмотреть: фильм, мультфильм или сериал?" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerData(input, angryAnswers, neutralAnswers, neutralAnswers);
	}
}
