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
			put("наигрался", "endOfGame");
			put("давай закончим", "endOfGame");
			put("хватит\\.*", "endOfGame");
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
		String currentMove = "какая-то строка";
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
			return new AnswerData("Вы точно хотите завершить игру?", true);
		}
		default:
			return nextCity(input);
		}

	}

	private AnswerData start(InputData input) {
		String answer = TownsMemory.getUnusedTown("Ыа");
		TownsData.setLastCity(answer);
		return new AnswerData(answer, true);
	}

	private AnswerData nextCity(InputData input) {
		if (!equalsFirstAndLastLetter(input.textMessage)) {
			String answer = "Первая буква \"" + input.textMessage + "\" и последняя буква \"" + TownsData.getLastCity()
					+ "\" не совпадают. Вы проиграли.";
			reboot();
			return new AnswerData(answer, false);
		}
		if (checkInUsed(input.textMessage)) {
			String answer = "Этот город уже называли ранее." + "Вы проиграли.";
			reboot();
			return new AnswerData(answer, false);
		}
		if (!checkInUnused(input.textMessage)) {
			String answer = "Этого города нет в моей базе данных. "
					+ "Скорее всего это не город и Вы пытаетесь меня обмануть. " + "Вы проиграли.";
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
		return new AnswerData("Я не смог подобрать нужного названия(" + "Вы выиграли", false);
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
		while (s.charAt(s.length() - i) == 'ь' || s.charAt(s.length() - i) == 'ы') {
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
		userAnswer = userAnswer.replaceAll("[^а-я]", "");
		if (userAnswer.equals("да")) {
			reboot();
			return new AnswerData("Спасибо, было приятно поиграть. Приходи ещё!", false);
		}
		if (userAnswer.equals("нет")) {
			TownsData.continueGame();
			String answer = "Давай продолжим тогда. Последним был город: " + TownsData.getLastCity();
			return new AnswerData(answer, true);
		}
		return new AnswerData(
				"К сожалению, я пока ещё не очень умный бот и не понимаю тебя. " + "Ты будешь ещё играть?", true);
	}
}