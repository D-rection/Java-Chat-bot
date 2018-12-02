package numbers;

import java.util.regex.Pattern;

public class GuessNumber {

	public String getAnswer(String mess, UnknownNumber unknowNumber) {

		Pattern pattern1 = Pattern.compile("отгадывать");

		if (pattern1.matcher(mess).find()) {
			return "Окей.Я загадал число от 0 до 100:) Твоя задача его отгадать))) Не бойся я буду давать подсказки:D Вот первая: Введи число:)";
		} else {
			String number = mess.replaceAll("[^0-9]", "");
			int UserNumber = Integer.parseInt(number);
			if (UserNumber > unknowNumber.getBotNumber()) {
				return "Моё число меньше.";
			} else if (UserNumber < unknowNumber.getBotNumber()) {
				return "Моё число больше.";
			} else {
				return "Ты угадал!";
			}
		}
	}
}
