package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;
import bot.Mood;

public class Film implements TopicConversation {
	public static String[] angryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
			"Давай как-нибудь сам" };
	public static String[] neutralAnswers = { "Пожалуй посмотри ", "Можешь посмотреть ", "Советую посмотреть ",
			"Я бы рекомендовал посмотреть ", "Кинопоиск подсказывает мне: " };
	public static String[] cheerfulAnswers = {
			"Я бы на твоём месте не тратил на это свою жизнь, но ты можешь посмотреть ", "Мне очень нравится ",
			"Несколько раз пересматривал ", "Люблю всем советовать: ", "Никогда не смотрю фильмы.Шутка:D Глянь " };
	public static String[] films = { "Сплит", "Живая сталь", "Железный человек", "Виноваты звёзды", "Время",
			"Первому игроку приготовиться", "Мстители", "Дома странных детей", "Kingsman", "Нерв", "Великий Гэтсби",
			"Люси", "Пираты Карибского моря", "Малыш на драйве", "Аннигиляция", "Интерстеллар",
			"Отличница лёгкого поведения", "Гарри Поттер", "Джуманджи", "Одарённая", "Скрытые фигуры", "Оно", "Чудо",
			"Джунгли", "Атландида", "Книга Генри", "До костей", "Между нами горы", "Очень плохие девчонки",
			"По соображениям совести" };

	public AnswerData getAnswerData(InputData input) {
		if (input.currentAttitude.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return new AnswerData(angryAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * films.length);
			String film = films[random];
			if (input.currentAttitude.getFriendliness() == Mood.Neutral) {
				int random1 = 0 + (int) (Math.random() * neutralAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", neutralAnswers[random1], film), false);
			} else {
				int random2 = 0 + (int) (Math.random() * cheerfulAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", cheerfulAnswers[random2], film), false);
			}
		}
	}

}
