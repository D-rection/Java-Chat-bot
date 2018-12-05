package numbers;

import bot.TopicConversation;
import java.util.HashSet;
import java.util.regex.Pattern;
import bot.AnswerData;
import bot.InputData;
import java.util.HashMap;

public class PlayNumbers implements TopicConversation {
	private String[] angryAnswers = { "Я не хочу с тобой играть...", "Поиграй с кем-нибудь другим", "Ты обидел меня(" };

	private UnknownNumber unknowNumber;

	private HashMap<String, Pattern> patterns = new HashMap<String, Pattern>() {
		{
			put("play", Pattern.compile("сыграем|поиграем"));
			put("guess", Pattern.compile("отгадывать"));
			put("numbers", Pattern.compile("\\d+"));
			put("make", Pattern.compile("загадывать"));
			put("answers", Pattern.compile("готов|да|меньше|больше"));
		}
	};

	public AnswerData getAnswerData(InputData input) {
		String mess = input.textMessage.toLowerCase();
		if (patterns.get("play").matcher(mess).find()) {
			if (input.currentAttitude.isAngry()) {
				int random = 0 + (int) (Math.random() * angryAnswers.length);
				return new AnswerData(angryAnswers[random], false);
			}
			return new AnswerData("Хорошо давай сыграем. Ты хочешь отгадывать или загадывать?", true);
		} else if (patterns.get("guess").matcher(mess).find() || patterns.get("numbers").matcher(mess).find()) {
			if (patterns.get("guess").matcher(mess).find()) {
				unknowNumber = new UnknownNumber();
				unknowNumber.setBotNumber((int) Math.floor(Math.random() * 100));
			}
			String answer = new GuessNumber().getAnswer(mess, unknowNumber);
			if (answer == "Ты угадал!") {
				input.currentAttitude.increasedFriendliness();
				return new AnswerData(answer, false);
			} else {
				return new AnswerData(answer, true);
			}
		} else if (patterns.get("make").matcher(mess).find() || patterns.get("answers").matcher(mess).find()) {
			if (patterns.get("make").matcher(mess).find()) {
				unknowNumber = new UnknownNumber();
			}
			String answer = new MakeNumber().getAnswer(mess, unknowNumber);
			if (mess == "угадал") {
				input.currentAttitude.increasedFriendliness();
				return new AnswerData(answer, false);
			} else {
				return new AnswerData(answer, true);
			}
		} else {
			input.currentAttitude.decreaseFriendliness();
			return new AnswerData("Это не верный ответ!!!Ты проиграл(", false);
		}
	}

	private HashSet<Pattern> triggers = new HashSet<Pattern>() {
		{
			add(Pattern.compile("поиграем\\s.*числа"));
			add(Pattern.compile("сыграем\\s.*числа"));
			add(Pattern.compile("отгадывать"));
			add(Pattern.compile("загадывать"));
		}
	};

	@Override
	public HashSet<Pattern> getTriggers() {
		return (HashSet<Pattern>) triggers.clone();
	}
}
