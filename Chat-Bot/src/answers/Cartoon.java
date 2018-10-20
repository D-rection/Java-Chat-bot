package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;
import bot.Mood;

public class Cartoon implements TopicConversation {
	public static String[] angryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
			"Давай как-нибудь сам" };
	public static String[] neutralAnswers = { "Пожалуй посмотри ", "Можешь посмотреть ", "Советую посмотреть ",
			"Я бы рекомендовал посмотреть ", "Кинопоиск подсказывает мне: " };
	public static String[] cheerfulAnswers = {
			"Я бы на твоём месте не тратил на это свою жизнь, но ты можешь посмотреть ", "Мне очень нравится ",
			"Несколько раз пересматривал ", "Люблю всем советовать: ", "Никогда не смотрю фильмы.Шутка:D Глянь " };
	public static String[] cartoons = { "Переменная облачность", "Зверополис", "Как приручить дракона", "Вверх'",
			"Рапунцель:Запутанная история", "Маленький принц", "Хранители снов", "Холодное сердце", "Моана", "Гадкий я",
			"Мегамозг", "Семейка Крудс", "Университет монстров", "Монстры на каникулах", "Кот в сапогах:Три чертёнка",
			"Кунг-фу панда", "Ледниковый период", "Мадагаскар", "Шрек", "Тачки", "Книга джунглей", "Феи",
			"Монстр в париже", "Рио", "Ранго", "Фердинанд", "Вольт", "Принцесса и лягушка", "Дом", "Храбрая сердцем" };

	public AnswerData getAnswerData(InputData input) {
		if (input.currentAttitude.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return new AnswerData(angryAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * cartoons.length);
			String cartoon = cartoons[random];
			if (input.currentAttitude.getFriendliness() == Mood.Neutral) {
				int random1 = 0 + (int) (Math.random() * neutralAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", neutralAnswers[random1], cartoon), false);
			} else {
				int random2 = 0 + (int) (Math.random() * cheerfulAnswers.length);
				return new AnswerData(String.format("%s\"%s\".", cheerfulAnswers[random2], cartoon), false);
			}
		}
	}
}
