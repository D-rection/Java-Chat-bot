package numbers;

import java.util.regex.Pattern;

public class MakeNumber {
	public String getAnswer(String mess, UnknowNumber unknowNumber) {
		Pattern pattern1 = Pattern.compile("загадывать");
		Pattern pattern2 = Pattern.compile("угадал");
		Pattern pattern3 = Pattern.compile("меньше");
		Pattern pattern4 = Pattern.compile("больше");
		Pattern pattern5 = Pattern.compile("готов|да");

		if (pattern1.matcher(mess).find()) {
			unknowNumber.setMinNumber(0);
			unknowNumber.setMaxNumber(100);
			return "Окей.Загадай число от 0 до 100:) Моя задача его отгадать))) Только давай мне подсказки(меньше/больше):D Когда угадаю напиши:'угадал'))) Ты готов?";
		} else if (pattern2.matcher(mess).find()) {
			return "Урааа!!!Было приятно с тобой поиграть)))";
		} else if (pattern3.matcher(mess).find() || pattern4.matcher(mess).find() || pattern5.matcher(mess).find()) {
			if (pattern3.matcher(mess).find()) {
				unknowNumber.setMaxNumber(unknowNumber.getBotNumber());
			} else if (pattern4.matcher(mess).find()) {
				unknowNumber.setMinNumber(unknowNumber.getBotNumber());
			}
			unknowNumber.setBotNumber(
					unknowNumber.getMinNumber() + (unknowNumber.getMaxNumber() - unknowNumber.getMinNumber()) / 2);
			return unknowNumber.getBotNumber() + "?";
		} else {
			return "Это не верный ответ!!!Ты проиграл(";
		}
	}

}
