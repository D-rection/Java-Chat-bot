package answers;

import bot.TopicConversation;

import java.util.HashSet;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;

public class Film extends BaseTopicConversation implements TopicConversation {
	public String[] films = { "Сплит", "Живая сталь", "Железный человек", "Виноваты звёзды", "Время",
			"Первому игроку приготовиться", "Мстители", "Дома странных детей", "Kingsman", "Нерв", "Великий Гэтсби",
			"Люси", "Пираты Карибского моря", "Малыш на драйве", "Аннигиляция", "Интерстеллар",
			"Отличница лёгкого поведения", "Гарри Поттер", "Джуманджи", "Одарённая", "Скрытые фигуры", "Оно", "Чудо",
			"Джунгли", "Атландида", "Книга Генри", "До костей", "Между нами горы", "Очень плохие девчонки",
			"По соображениям совести" };

	public AnswerData getAnswerData(InputData input) 
	{
		return super.getAnswerDataWithFilm(input, films);
	}

	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{
			add(Pattern.compile("(?iu:фильм|фильмец)"));
			add(Pattern.compile("(?iu:какой\\s.*фильм)"));
			add(Pattern.compile("(?iu:подскажи\\s.*фильм)"));
			add(Pattern.compile("(?iu:посоветуй\\s.*фильм)"));
		}
	};
	
	@Override
	public HashSet<Pattern> getTriggers() {
		return (HashSet<Pattern>) triggers.clone();
	}
	
	
}
