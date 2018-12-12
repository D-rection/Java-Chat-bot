package numbers;

import java.util.regex.Pattern;

public class GuessNumber {
	
	private Pattern play = Pattern.compile("(?iu:отгадывать)");

	public String getAnswer(String mess, UnknownNumber unknownNumber) {
		if (play.matcher(mess).find()) {
			return "Окей.Я загадал число от 0 до 100:) Твоя задача его отгадать))) Не бойся я буду давать подсказки:D Вот первая: Введи число:)";
		} else {
			String number = mess.replaceAll("[^0-9]", "");
			int UserNumber = Integer.parseInt(number);
			if (UserNumber > unknownNumber.getBotNumber()) {
				return "Моё число меньше.";
			} else if (UserNumber < unknownNumber.getBotNumber()) {
				return "Моё число больше.";
			} else {
				return "Ты угадал!";
			}
		}
	}
}
