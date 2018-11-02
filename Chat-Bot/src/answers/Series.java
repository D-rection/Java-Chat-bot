package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;

public class Series extends BaseTopicConversation implements TopicConversation {
	public static String[] series = { "Сверхъестественное", "Очень странные дела", "Американская история ужасов",
			"Оранжевый - хит сезона", "Теория большого взрыва", "Ходячие мертвецы", "Во все тяжкие", "Игра престолов",
			"Шерлок", "Обмани меня", "Отбросы", "Чёрное зеркало", "Красные браслеты" };
	
	public AnswerData getAnswerData(InputData input) {
        return super.getAnswerDataWithFilm(input, series);
	}
}
