package towns;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;

public class TownsGame implements TopicConversation {
	private HashSet<String> patternToAnalysis = new HashSet<String>() 
	{
		{
			add("наигрался");
			add("давай закончим");
			add("хватит");
		}
	};
	
	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{
			add(Pattern.compile("города"));
		}
	};

	private TownsData townsData = new TownsData();
	private TownsMemory townsMemory = new TownsMemory();
	private HashSet<Character> invalidCharacter = new HashSet<>(Arrays.asList('ъ','ь','ы'));
	
	public AnswerData getAnswerData(InputData input) 
	{
		if (townsData.isEndOfGame())
			return endOfGame(input);
		if (townsData.isStart()) {
			reboot();
			townsData.firstCityWas();
			return start(input);
		}
		String message = String.join(" ", input.textMessage.toLowerCase().split("[ {,|.}?]+"));
		if (patternToAnalysis.contains(message)) 
		{
			townsData.endOfGame();
			return new AnswerData("Вы точно хотите завершить игру?", true);
		}
		else
			return nextCity(input);
	}

	private AnswerData start(InputData input) 
	{
		String answer = townsMemory.getUnusedTownAndAddItToUsed("Яяа");
		townsData.setLastCity(answer);
		return new AnswerData(answer, true);
	}

	private AnswerData nextCity(InputData input) 
	{
		if (!equalsFirstAndLastLetter(input.textMessage)) {
			String answer = "Первая буква \"" + input.textMessage 
					+ "\" и последняя буква \"" + townsData.getLastCity()
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
		townsMemory.useTown(getTrueNameCity(input.textMessage));
		String answer = townsMemory.getUnusedTownAndAddItToUsed(input.textMessage);
		if (answer != null) {
			townsData.setLastCity(answer);
			return new AnswerData(answer, true);
		}
		reboot();
		return new AnswerData("Я не смог подобрать нужного названия(" + "Вы выиграли", false);
	}

	private String getTrueNameCity(String s) 
	{
		String d = s.substring(0, 1).toUpperCase();
		d = d + s.substring(1);
		return d;
	}

	private boolean checkInUnused(String s) 
	{
		return townsMemory.containsUnusedTowns(getTrueNameCity(s));
	}

	private boolean checkInUsed(String s) 
	{
		return townsMemory.containsUsedTowns(getTrueNameCity(s));
	}

	private Character getLastLetter(String s) 
	{
		int i = 1;
		boolean trueInput = i <= s.length();
		while (invalidCharacter.contains(s.charAt(s.length() - i)) && trueInput) 
		{
			i++;
			if (i >= s.length())
				trueInput = false;
		}
		return trueInput ? s.charAt(s.length() - i) : null;
	}

	private boolean equalsFirstAndLastLetter(String s) 
	{
		String str = s.toLowerCase();
		Character c = getLastLetter(townsData.getLastCity());
		Character d = str.charAt(0);
		return c.equals(d);
	}

	private void reboot() 
	{
		townsData.reboot();
		townsMemory.reboot();
	}

	private AnswerData endOfGame(InputData input) 
	{
		String userAnswer = input.textMessage.toLowerCase().trim();
		userAnswer = userAnswer.replaceAll("[^а-я]", "");
		if (userAnswer.equals("да")) {
			reboot();
			return new AnswerData("Спасибо, было приятно поиграть. Приходи ещё!", false);
		}
		if (userAnswer.equals("нет")) {
			townsData.continueGame();
			String answer = "Давай продолжим тогда. Последним был город: " + townsData.getLastCity();
			return new AnswerData(answer, true);
		}
		return new AnswerData(
				"К сожалению, я пока ещё не очень умный бот и не понимаю тебя. " + "Ты будешь ещё играть?", true);
	}

	@Override
	public HashSet<Pattern> getTriggers() 
	{
		return (HashSet<Pattern>) triggers.clone();
	}
}