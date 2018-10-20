package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;
import bot.Mood;

public class Cartoon implements TopicConversation {
	public static String[] angryAnswers = { "��� ���", "� �� ���� ���� ��������", "������, ��� ������", "���� ������",
			"����� ���-������ ���" };
	public static String[] neutralAnswers = { "������� �������� ", "������ ���������� ", "������� ���������� ",
			"� �� ������������ ���������� ", "��������� ������������ ���: " };
	public static String[] cheerfulAnswers = {
			"� �� �� ���� ����� �� ������ �� ��� ���� �����, �� �� ������ ���������� ", "��� ����� �������� ",
			"��������� ��� ������������� ", "����� ���� ����������: ", "������� �� ������ ������.�����:D ����� " };
	public static String[] cartoons = { "���������� ����������", "����������", "��� ��������� �������", "�����'",
			"���������:���������� �������", "��������� �����", "��������� ����", "�������� ������", "�����", "������ �",
			"��������", "������� �����", "����������� ��������", "������� �� ���������", "��� � �������:��� �������",
			"����-�� �����", "���������� ������", "����������", "����", "�����", "����� ��������", "���",
			"������ � ������", "���", "�����", "���������", "�����", "��������� � �������", "���", "������� �������" };

	public AnswerData getAnswerData(InputData input) {
		if (input.currentAttitude.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return new AnswerData(angryAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * cartoons.length);
			String cartoon = cartoons[random];
			if (input.currentAttitude.getFriendliness() == Mood.Neutral) {
				int random1 = 0 + (int) (Math.random() * neutralAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", neutralAnswers[random1], cartoon), false);
			} else {
				int random2 = 0 + (int) (Math.random() * cheerfulAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", cheerfulAnswers[random2], cartoon), false);
			}
		}
	}
}
