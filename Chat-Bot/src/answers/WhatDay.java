package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;

public class WhatDay extends BaseTopicConversation implements TopicConversation {
	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerDataWithDate(input, "'Сегодня' EE dd.MM.yyyy");
	}
}
