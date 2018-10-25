package numbers;

import bot.TopicConversation;
import java.util.regex.Pattern;
import bot.AnswerData;
import bot.InputData;

public class PlayNumbers implements TopicConversation {
	
	private UnknowNumber unknowNumber;

	public AnswerData getAnswerData(InputData input) {
		Pattern pattern1 = Pattern.compile("сыграем|поиграем");
		Pattern pattern2 = Pattern.compile("отгадывать");
		Pattern pattern3 = Pattern.compile("\\d+");
		Pattern pattern4 = Pattern.compile("загадывать");
		Pattern pattern5 = Pattern.compile("готов|да");
		Pattern pattern6 = Pattern.compile("меньше|больше");
		String mess = input.textMessage;
		if (pattern1.matcher(mess).find()) {
			return new AnswerData("Хорошо давай сыграем. Ты хочешь отгадывать или загадывать?", true);
		} else if (pattern2.matcher(mess).find() || pattern3.matcher(mess).find()) {
			if (pattern2.matcher(mess).find()) {
				unknowNumber = new UnknowNumber();
				unknowNumber.setBotNumber((int) Math.floor(Math.random() * 100));
			}
			String answer = new GuessNumber().getAnswer(mess, unknowNumber);
			if (answer == "Ты угадал!") {
				return new AnswerData(answer, false);
			} else {
				return new AnswerData(answer, true);
			}
		} else if (pattern4.matcher(mess).find() || pattern5.matcher(mess).find() || pattern6.matcher(mess).find()) {
			if (pattern4.matcher(mess).find()) {
				unknowNumber = new UnknowNumber();
			}
			String answer = new MakeNumber().getAnswer(mess, unknowNumber);
			if (mess == "угадал") {
				return new AnswerData(answer, false);
			} else {
				return new AnswerData(answer, true);
			}
		} else {
			return new AnswerData("Это не верный ответ!!!Ты проиграл(", false);
		}
	}
}
