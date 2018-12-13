package answers;

import bot.TopicConversation;

import java.util.HashSet;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;

public class Cartoon extends BaseTopicConversation implements TopicConversation {
	public String[] cartoons = { "Переменная облачность", "Зверополис", "Как приручить дракона", "Вверх'",
			"Рапунцель:Запутанная история", "Маленький принц", "Хранители снов", "Холодное сердце", "Моана", "Гадкий я",
			"Мегамозг", "Семейка Крудс", "Университет монстров", "Монстры на каникулах", "Кот в сапогах:Три чертёнка",
			"Кунг-фу панда", "Ледниковый период", "Мадагаскар", "Шрек", "Тачки", "Книга джунглей", "Феи",
			"Монстр в париже", "Рио", "Ранго", "Фердинанд", "Вольт", "Принцесса и лягушка", "Дом", "Храбрая сердцем" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerDataWithFilm(input, cartoons);
	}

	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{
			add(Pattern.compile("мультфильм"));
			add(Pattern.compile("мультик"));
			add(Pattern.compile("какой\\s.*мультфильм"));
			add(Pattern.compile("подскажи\\s.*мультфильм"));
			add(Pattern.compile("посоветуй\\s.*мультфильм"));
		}
	};
	
	@Override
	public HashSet<Pattern> getTriggers() 
	{
		return (HashSet<Pattern>) triggers.clone();
	}
}
