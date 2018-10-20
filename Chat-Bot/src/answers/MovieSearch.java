package answers;

import bot.Attitude;
import bot.Mood;

public class MovieSearch {

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
	public static String[] films = { "�����", "����� �����", "�������� �������", "�������� �����", "�����",
			"������� ������ �������������", "��������", "���� �������� �����", "Kingsman", "����", "������� ������",
			"����", "������ ���������� ����", "����� �� ������", "�����������", "������������",
			"��������� ������ ���������", "����� ������", "���������", "��������", "������� ������", "���", "����",
			"�������", "���������", "����� �����", "�� ������", "����� ���� ����", "����� ������ ��������",
			"�� ������������ �������" };
	public static String[] series = { "������������������", "����� �������� ����", "������������ ������� ������",
			"��������� - ��� ������", "������ �������� ������", "������� ��������", "�� ��� ������", "���� ���������",
			"������", "������ ����", "�������", "׸���� �������", "������� ��������" };

	public static String getMovie(Attitude a, String key) {
		if (a.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return angryAnswers[random];
		} else if (key == "whatwatch") {
			return "��� �� ������ ����������: �����, ���������� ��� ������?";
		} else {
			String movie = "";
			if (key == "cartoon") {
				int random = 0 + (int) (Math.random() * cartoons.length);
				movie = cartoons[random];
			} else if (key == "film") {
				int random = 0 + (int) (Math.random() * films.length);
				movie = films[random];
			} else {
				int random = 0 + (int) (Math.random() * series.length);
				movie = series[random];
			}
			if (a.getFriendliness() == Mood.Neutral) {
				int random1 = 0 + (int) (Math.random() * neutralAnswers.length);
				return String.format("%s\"%s\".", neutralAnswers[random1], movie);
			} else {
				int random2 = 0 + (int) (Math.random() * cheerfulAnswers.length);
				return String.format("%s\"%s\".", cheerfulAnswers[random2], movie);
			}
		}
	}

}
