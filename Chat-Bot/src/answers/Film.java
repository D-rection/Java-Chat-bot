package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.BaseTopicConversation;
import bot.InputData;

public class Film extends BaseTopicConversation implements TopicConversation {
	public static String[] films = { "Сплит", "Живая сталь", "Железный человек", "Виноваты звёзды", "Время",
			"Первому игроку приготовиться", "Мстители", "Дома странных детей", "Kingsman", "Нерв", "Великий Гэтсби",
			"Люси", "Пираты Карибского моря", "Малыш на драйве", "Аннигиляция", "Интерстеллар",
			"Отличница лёгкого поведения", "Гарри Поттер", "Джуманджи", "Одарённая", "Скрытые фигуры", "Оно", "Чудо",
			"Джунгли", "Атландида", "Книга Генри", "До костей", "Между нами горы", "Очень плохие девчонки",
			"По соображениям совести" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerDataWithFilm(input, films);
	}
}
