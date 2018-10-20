package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;

public class WhatCan implements TopicConversation {

	public AnswerData getAnswerData(InputData input) {
		StringBuilder strb = new StringBuilder();
		strb.append("���� � ���� ���� ����, �� ����� ���� ������ ����������.");
		strb.append("C����� � ���� ���������� ��� ���� � �����.");
		strb.append("� ������ ���������� � ���� � ���� ������������, ��� ��� ����������:)");
		strb.append("��� �� ����� �������� � \"�����\" ��� \"������\".");
		strb.append("� �� ���������, ��� �� ������ ������ ��������� �� ����, ���� � ����� ����� �������� � ������^-^.");
		String answer = strb.toString();
		return new AnswerData(answer, false);
	}

}
