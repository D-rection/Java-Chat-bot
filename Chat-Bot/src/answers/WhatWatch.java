package answers;

import bot.TopicConversation;

import java.util.HashSet;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;

public class WhatWatch extends BaseTopicConversation implements TopicConversation {
	public String[] angryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
			"Давай как-нибудь сам" };
	public String[] neutralAnswers = { "Что ты хочешь посмотреть: фильм, мультфильм или сериал?" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerData(input, angryAnswers, neutralAnswers, neutralAnswers);
	}

	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{			 
			add(Pattern.compile("(?iu:что\\s.*посмотреть)")); 
			add(Pattern.compile("(?iu:что\\s.глянуть)"));
		}
	};
	
	@Override
	public HashSet<Pattern> getTriggers() {
		return (HashSet<Pattern>) triggers.clone();
	}
}
