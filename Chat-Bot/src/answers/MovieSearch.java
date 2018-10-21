package answers;

import bot.Attitude;
import bot.Mood;

public class MovieSearch {

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
	public static String[] films = { "Сплит", "Живая сталь", "Железный человек", "Виноваты звёзды", "Время",
			"Первому игроку приготовиться", "Мстители", "Дома странных детей", "Kingsman", "Нерв", "Великий Гэтсби",
			"Люси", "Пираты Карибского моря", "Малыш на драйве", "Аннигиляция", "Интерстеллар",
			"Отличница лёгкого поведения", "Гарри Поттер", "Джуманджи", "Одарённая", "Скрытые фигуры", "Оно", "Чудо",
			"Джунгли", "Атландида", "Книга Генри", "До костей", "Между нами горы", "Очень плохие девчонки",
			"По соображениям совести" };
	public static String[] series = { "Сверхъестественное", "Очень странные дела", "Американская история ужасов",
			"Оранжевый - хит сезона", "Теория большого взрыва", "Ходячие мертвецы", "Во все тяжкие", "Игра престолов",
			"Шерлок", "Обмани меня", "Отбросы", "Чёрное зеркало", "Красные браслеты" };

	public static String getMovie(Attitude a, String key) {
		if (a.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return angryAnswers[random];
		} else if (key == "whatwatch") {
			return "Что ты хочешь посмотреть: фильм, мультфильм или сериал?";
		} else {
			String movie = "";
			if (key == "cartoon") {
				int random = 0 + (int) (Math.random() * cartoons.length);
				movie = cartoons[random];
			} else if (key == "film") {
				int random = 0 + (int) (Math.random() * films.length);
				movie = films[random];
			} else {
				int random = 0 + (int) (Math.random() * series.length);
				movie = series[random];
			}
			if (a.getFriendliness() == Mood.Neutral) {
				int random1 = 0 + (int) (Math.random() * neutralAnswers.length);
				return String.format("%s\"%s\".", neutralAnswers[random1], movie);
			} else {
				int random2 = 0 + (int) (Math.random() * cheerfulAnswers.length);
				return String.format("%s\"%s\".", cheerfulAnswers[random2], movie);
			}
		}
	}

}
