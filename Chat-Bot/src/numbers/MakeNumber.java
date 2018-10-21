package numbers;

import java.util.regex.Pattern;

public class MakeNumber {
	public String getAnswer(String mess) {
		Pattern pattern1 = Pattern.compile("загадывать");
		Pattern pattern2 = Pattern.compile("угадал");
		Pattern pattern3 = Pattern.compile("меньше");
		Pattern pattern4 = Pattern.compile("больше");

		if (pattern1.matcher(mess).find()) {
			UnknowNumber.setMinNumber(0);
			UnknowNumber.setMaxNumber(100);
			return "Окей.Загадай число от 0 до 100:) Моя задача его отгадать))) Только давай мне подсказки(меньше/больше):D Когда угадаю напиши:'угадал'))) Ты готов?";
		} else if (pattern2.matcher(mess).find()) {
			return "Урааа!!!Было приятно с тобой поиграть)))";
		} else {
			if (pattern3.matcher(mess).find()) {
				UnknowNumber.setMaxNumber(UnknowNumber.getBotNumber());
			} else if (pattern4.matcher(mess).find()) {
				UnknowNumber.setMinNumber(UnknowNumber.getBotNumber());
			}
			UnknowNumber.setBotNumber(
					UnknowNumber.getMinNumber() + (UnknowNumber.getMaxNumber() - UnknowNumber.getMinNumber()) / 2);
			return UnknowNumber.getBotNumber() + "?";
		}
	}

}
