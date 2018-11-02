package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.BaseTopicConversation;
import bot.InputData;

public class Cartoon extends BaseTopicConversation implements TopicConversation {
	public static String[] cartoons = { "Переменная облачность", "Зверополис", "Как приручить дракона", "Вверх'",
			"Рапунцель:Запутанная история", "Маленький принц", "Хранители снов", "Холодное сердце", "Моана", "Гадкий я",
			"Мегамозг", "Семейка Крудс", "Университет монстров", "Монстры на каникулах", "Кот в сапогах:Три чертёнка",
			"Кунг-фу панда", "Ледниковый период", "Мадагаскар", "Шрек", "Тачки", "Книга джунглей", "Феи",
			"Монстр в париже", "Рио", "Ранго", "Фердинанд", "Вольт", "Принцесса и лягушка", "Дом", "Храбрая сердцем" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerDataWithFilm(input, cartoons);
	}
}
