package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.BaseTopicConversation;
import bot.InputData;

public class WhatTime extends BaseTopicConversation implements TopicConversation {
	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerDataWithDate(input, "'Сейчас' kk:mm");
	}
}
