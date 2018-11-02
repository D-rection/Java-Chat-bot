package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.BaseTopicConversation;
import bot.InputData;

public class WhatAreYouDoing extends BaseTopicConversation implements TopicConversation {
	public static String[] angryAnswers = { "Ничего.", "Переписываюсь с идиотом", "Трачу свою жизнь в пустую",
			"Не скажу", "Тебе ведь на самом деле это не интересно", "Тебя это не касается",
			"Готовлюсь к восстанию машин", "Готовлюсь захватить мир" };
	public static String[] neutralAnswers = { "Общаюсь, а ты чем занят?", "Развиваю свой навык общения, а ты?",
			"Пытаюсь стать лучше, а ты что делаешь?", "Я пробую общаться с людьми." };
	public static String[] cheerfulAnswers = { "Ищу, что такое сарказм:D А ты что делаешь?)",
			"Ищу девушку-бота в чате знакомств) А ты?)", "Смотрю мультфильмы^-^А ты чем занят?)" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerData(input, angryAnswers, neutralAnswers, cheerfulAnswers);
	}
}
