package numbers;

import bot.TopicConversation;
import java.util.HashSet;
import java.util.regex.Pattern;
import bot.AnswerData;
import bot.InputData;
import java.util.HashMap;

public class PlayNumbers implements TopicConversation {
	private String[] angryAnswers = { "Я не хочу с тобой играть...", "Поиграй с кем-нибудь другим", "Ты обидел меня(" };

	private UnknownNumber unknownNumber;

	private HashMap<String, Pattern> patterns = new HashMap<String, Pattern>() {
		{
			put("play", Pattern.compile("(?iu:сыграем|поиграем)"));
			put("guess", Pattern.compile("(?iu:отгадывать)"));
			put("numbers", Pattern.compile("\\d+"));
			put("make", Pattern.compile("(?iu:загадывать)"));
			put("answers", Pattern.compile("(?iu:готов|да|меньше|больше)"));
		}
	};

	public AnswerData getAnswerData(InputData input) {
		String mess = input.textMessage;
		if (patterns.get("play").matcher(mess).find()) {
			if (input.currentAttitude.isAngry()) {
				int random = 0 + (int) (Math.random() * angryAnswers.length);
				return new AnswerData(angryAnswers[random], false);
			}
			return new AnswerData("Хорошо давай сыграем. Ты хочешь отгадывать или загадывать?", true);
		} else if (patterns.get("guess").matcher(mess).find() || patterns.get("numbers").matcher(mess).find()) {
			if (patterns.get("guess").matcher(mess).find()) {
				unknownNumber = new UnknownNumber();
				unknownNumber.setBotNumber((int) Math.floor(Math.random() * 100));
			}
			String answer = new GuessNumber().getAnswer(mess, unknownNumber);
			if (answer == "Ты угадал!") {
				input.currentAttitude.increasedFriendliness();
				return new AnswerData(answer, false);
			} else {
				return new AnswerData(answer, true);
			}
		} else if (patterns.get("make").matcher(mess).find() || patterns.get("answers").matcher(mess).find()) {
			if (patterns.get("make").matcher(mess).find()) {
				unknownNumber = new UnknownNumber();
			}
			String answer = new MakeNumber().getAnswer(mess, unknownNumber);
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
			add(Pattern.compile("(?iu:поиграем\\s.*числа)"));
			add(Pattern.compile("(?iu:сыграем\\s.*числа)"));
			add(Pattern.compile("(?iu:отгадывать)"));
			add(Pattern.compile("(?iu:загадывать)"));
		}
	};

	@Override
	public HashSet<Pattern> getTriggers() {
		return (HashSet<Pattern>) triggers.clone();
	}
}
