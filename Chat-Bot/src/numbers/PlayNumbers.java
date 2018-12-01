package numbers;

import bot.TopicConversation;
import java.util.HashSet;
import java.util.regex.Pattern;
import bot.AnswerData;
import bot.InputData;

public class PlayNumbers implements TopicConversation {
	String[] angryAnswers = {"Я не хочу с тобой играть...", "Поиграй с кем-нибудь другим", "Ты обидел меня(" };

	private UnknowNumber unknowNumber;

	public AnswerData getAnswerData(InputData input) {		
		Pattern pattern1 = Pattern.compile("сыграем|поиграем");
		Pattern pattern2 = Pattern.compile("отгадывать");
		Pattern pattern3 = Pattern.compile("\\d+");
		Pattern pattern4 = Pattern.compile("загадывать");
		Pattern pattern5 = Pattern.compile("готов|да");
		Pattern pattern6 = Pattern.compile("меньше|больше");
		String mess = input.textMessage.toLowerCase();
		if (pattern1.matcher(mess).find()) {
			if (input.currentAttitude.isAngry()){
				int random = 0 + (int) (Math.random() * angryAnswers.length);
				return new AnswerData(angryAnswers[random], false);
			}
			return new AnswerData("Хорошо давай сыграем. Ты хочешь отгадывать или загадывать?", true);
		} else if (pattern2.matcher(mess).find() || pattern3.matcher(mess).find()) {
			if (pattern2.matcher(mess).find()) {
				unknowNumber = new UnknowNumber();
				unknowNumber.setBotNumber((int) Math.floor(Math.random() * 100));
			}
			String answer = new GuessNumber().getAnswer(mess, unknowNumber);
			if (answer == "Ты угадал!") {
				input.currentAttitude.increasedFriendliness();
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

	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{
			add(Pattern.compile("поиграем\\s.*числа"));
			add(Pattern.compile("сыграем\\s.*числа"));
			add(Pattern.compile("отгадывать"));
			add(Pattern.compile("загадывать"));
		}
	};
	
	@Override
	public HashSet<Pattern> getTriggers() 
	{
		return (HashSet<Pattern>) triggers.clone();
	}
}
