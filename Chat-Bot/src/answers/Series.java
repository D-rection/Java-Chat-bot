package answers;

import bot.TopicConversation;

import java.util.HashSet;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;

public class Series extends BaseTopicConversation implements TopicConversation {
	public String[] series = { "Сверхъестественное", "Очень странные дела", "Американская история ужасов",
			"Оранжевый - хит сезона", "Теория большого взрыва", "Ходячие мертвецы", "Во все тяжкие", "Игра престолов",
			"Шерлок", "Обмани меня", "Отбросы", "Чёрное зеркало", "Красные браслеты" };
	
	public AnswerData getAnswerData(InputData input) {
        return super.getAnswerDataWithFilm(input, series);
	}
	
	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{
			add(Pattern.compile("(?iu:сериал|сериальчик)")); 		 
			add(Pattern.compile("(?iu:какой\\s.*сериал)")); 
			add(Pattern.compile("(?iu:подскажи\\s.*сериал)")); 
			add(Pattern.compile("(?iu:посоветуй\\s.*сериал)"));
		}
	};

	@Override
	public HashSet<Pattern> getTriggers() {
		return (HashSet<Pattern>) triggers.clone();
	}
}
