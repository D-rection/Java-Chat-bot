package numbers;

import java.util.HashMap;
import java.util.regex.Pattern;

public class MakeNumber {
	public HashMap<String, Pattern> patterns = new HashMap<String, Pattern>() {
		{
			put("play", Pattern.compile("загадывать"));
			put("finish", Pattern.compile("угадал"));
			put("<", Pattern.compile("меньше"));
			put(">", Pattern.compile("больше"));
		}
	};

	public String getAnswer(String mess, UnknownNumber unknowNumber) {
		if (patterns.get("play").matcher(mess).find()) {
			unknowNumber.setMinNumber(0);
			unknowNumber.setMaxNumber(100);
			return "Окей.Загадай число от 0 до 100:) Моя задача его отгадать))) Только давай мне подсказки(меньше/больше):D Когда угадаю напиши:'угадал'))) Ты готов?";
		} else if (patterns.get("finish").matcher(mess).find()) {
			return "Урааа!!!Было приятно с тобой поиграть)))";
		} else {
			if (patterns.get("<").matcher(mess).find()) {
				unknowNumber.setMaxNumber(unknowNumber.getBotNumber());
			} else if (patterns.get(">").matcher(mess).find()) {
				unknowNumber.setMinNumber(unknowNumber.getBotNumber());
			}
			unknowNumber.setBotNumber(
					unknowNumber.getMinNumber() + (unknowNumber.getMaxNumber() - unknowNumber.getMinNumber()) / 2);
			return unknowNumber.getBotNumber() + "?";
		}
	}

}
