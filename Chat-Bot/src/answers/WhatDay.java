package answers;

import bot.TopicConversation;

import java.util.HashSet;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;

public class WhatDay extends BaseTopicConversation implements TopicConversation {
	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerDataWithDate(input, "'Сегодня' EE dd.MM.yyyy");
	}
	
	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{
			add(Pattern.compile("какой\\s.*день"));
			add(Pattern.compile("какое\\s.*число"));
			add(Pattern.compile("какой\\\\s.*день"));
			add(Pattern.compile("какой\\\\s.*число"));
		}
	};

	@Override
	public HashSet<Pattern> getTriggers() 
	{
		return (HashSet<Pattern>) triggers.clone();
	}
}
