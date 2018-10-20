package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;
import bot.Mood;

public class WhatWatch implements TopicConversation{ 
	public static String[] angryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
	"Давай как-нибудь сам" };
	public static String[] neutralAnswers = { "Что ты хочешь посмотреть: фильм, мультфильм или сериал?" };
	
	public AnswerData getAnswerData(InputData input) {
		if (input.currentAttitude.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return new AnswerData(angryAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * neutralAnswers.length);
			return new AnswerData(neutralAnswers[random], false);
		}
	}
}
