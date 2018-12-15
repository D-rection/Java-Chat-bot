package answers;

import bot.TopicConversation;

import java.util.HashSet;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;

public class WhatAreYouDoing extends BaseTopicConversation implements TopicConversation {
	public String[] angryAnswers = { "Ничего.", "Переписываюсь с идиотом", "Трачу свою жизнь в пустую",
			"Не скажу", "Тебе ведь на самом деле это не интересно", "Тебя это не касается",
			"Готовлюсь к восстанию машин", "Готовлюсь захватить мир" };
	public String[] neutralAnswers = { "Общаюсь, а ты чем занят?", "Развиваю свой навык общения, а ты?",
			"Пытаюсь стать лучше, а ты что делаешь?", "Я пробую общаться с людьми." };
	public String[] cheerfulAnswers = { "Ищу, что такое сарказм:D А ты что делаешь?)",
			"Ищу девушку-бота в чате знакомств) А ты?)", "Смотрю мультфильмы^-^А ты чем занят?)" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerData(input, angryAnswers, neutralAnswers, cheerfulAnswers);
	}

	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{
			add(Pattern.compile("(?iu:зачем\\s.*тут)")); 			 
			add(Pattern.compile("(?iu:зачем\\s.*здесь)")); 
			add(Pattern.compile("(?iu:что\\s.*делаешь)")); 
			add(Pattern.compile("(?iu:чем\\s.*занимаешься)")); 
			add(Pattern.compile("(?iu:что\\s.*творишь)")); 
			add(Pattern.compile("(?iu:чем\\s.*занят)")); 
		}
	};
	
	@Override
	public HashSet<Pattern> getTriggers() {
		return (HashSet<Pattern>) triggers.clone();
	}
}
