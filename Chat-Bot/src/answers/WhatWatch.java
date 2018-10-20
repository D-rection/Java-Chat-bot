package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;
import bot.Mood;

public class WhatWatch implements TopicConversation{ 
	public static String[] angryAnswers = { "��� ���", "� �� ���� ���� ��������", "������, ��� ������", "���� ������",
	"����� ���-������ ���" };
	public static String[] neutralAnswers = { "��� �� ������ ����������: �����, ���������� ��� ������?" };
	
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
