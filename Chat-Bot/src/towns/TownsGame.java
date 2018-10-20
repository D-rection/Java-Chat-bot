package towns;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;

public class TownsGame implements TopicConversation {
	private Map<String, String> patternToAnalysis = new HashMap<String, String>() {
		{
			put("���������", "endOfGame");
			put("����� ��������", "endOfGame");
			put("������\\.*", "endOfGame");
		}
	};

	public AnswerData getAnswerData(InputData input) {
		if (TownsData.isEndOfGame())
			return endOfGame(input);
		if (TownsData.isStart()) {
			reboot();
			TownsData.firstCityWas();
			return start(input);
		}
		String currentMove = "�����-�� ������";
		String message = String.join(" ", input.textMessage.toLowerCase().split("[ {,|.}?]+"));
		for (String o : patternToAnalysis.keySet()) {
			Pattern pattern = Pattern.compile(o);
			if (pattern.matcher(message).find()) {
				currentMove = patternToAnalysis.get(o);
				break;
			}
		}
		switch (currentMove) {
		case "endOfGame": {
			TownsData.endOfGame();
			return new AnswerData("�� ����� ������ ��������� ����?", true);
		}
		default:
			return nextCity(input);
		}

	}

	private AnswerData start(InputData input) {
		String answer = TownsMemory.getUnusedTown("��");
		TownsData.setLastCity(answer);
		return new AnswerData(answer, true);
	}

	private AnswerData nextCity(InputData input) {
		if (!equalsFirstAndLastLetter(input.textMessage)) {
			String answer = "������ ����� \"" + input.textMessage + "\" � ��������� ����� \"" + TownsData.getLastCity()
					+ "\" �� ���������. �� ���������.";
			reboot();
			return new AnswerData(answer, false);
		}
		if (checkInUsed(input.textMessage)) {
			String answer = "���� ����� ��� �������� �����." + "�� ���������.";
			reboot();
			return new AnswerData(answer, false);
		}
		if (!checkInUnused(input.textMessage)) {
			String answer = "����� ������ ��� � ���� ���� ������. "
					+ "������ ����� ��� �� ����� � �� ��������� ���� ��������. " + "�� ���������.";
			reboot();
			return new AnswerData(answer, false);
		}
		TownsMemory.useTown(getTrueNameCity(input.textMessage));
		String answer = TownsMemory.getUnusedTown(input.textMessage);
		if (answer != null) {
			TownsData.setLastCity(answer);
			return new AnswerData(answer, true);
		}
		reboot();
		return new AnswerData("� �� ���� ��������� ������� ��������(" + "�� ��������", false);
	}

	private String getTrueNameCity(String s) {
		String town = s.toLowerCase();
		String d = s.substring(0, 1).toUpperCase();
		d = d + s.substring(1);
		return d;
	}

	private boolean checkInUnused(String s) {
		return TownsMemory.containsUnusedTowns(getTrueNameCity(s));
	}

	private boolean checkInUsed(String s) {
		return TownsMemory.containsUsedTowns(getTrueNameCity(s));
	}

	private Character getLastLetter(String s) {
		int i = 1;
		while (s.charAt(s.length() - i) == '�' || s.charAt(s.length() - i) == '�') {
			i++;
		}
		return s.charAt(s.length() - i);
	}

	private boolean equalsFirstAndLastLetter(String s) {
		String str = s.toLowerCase();
		Character c = getLastLetter(TownsData.getLastCity());
		Character d = str.charAt(0);
		return c.equals(d);
	}

	private void reboot() {
		TownsData.reboot();
		TownsMemory.reboot();
	}

	private AnswerData endOfGame(InputData input) {
		String userAnswer = input.textMessage.toLowerCase().trim();
		userAnswer = userAnswer.replaceAll("[^�-�]", "");
		if (userAnswer.equals("��")) {
			reboot();
			return new AnswerData("�������, ���� ������� ��������. ������� ���!", false);
		}
		if (userAnswer.equals("���")) {
			TownsData.continueGame();
			String answer = "����� ��������� �����. ��������� ��� �����: " + TownsData.getLastCity();
			return new AnswerData(answer, true);
		}
		return new AnswerData(
				"� ���������, � ���� ��� �� ����� ����� ��� � �� ������� ����. " + "�� ������ ��� ������?", true);
	}
}