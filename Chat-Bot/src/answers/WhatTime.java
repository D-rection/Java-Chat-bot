package answers;

import bot.TopicConversation;

import java.util.HashSet;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;

public class WhatTime extends BaseTopicConversation implements TopicConversation {
	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerDataWithDate(input, "'Сейчас' kk:mm");
	}
	
	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{

			add(Pattern.compile("(?iu:который\\s.*час)")); 
			add(Pattern.compile("(?iu:сколько\\s.*время)")); 
		}
	};

	@Override
	public HashSet<Pattern> getTriggers() 
	{
		return (HashSet<Pattern>) triggers.clone();
	}
}
