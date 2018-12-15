package answers;

public class Series extends BaseFilmTopicConversation  {
	public static final String[] series = { "Сверхъестественное", "Очень странные дела", "Американская история ужасов",
			"Оранжевый - хит сезона", "Теория большого взрыва", "Ходячие мертвецы", "Во все тяжкие", "Игра престолов",
			"Шерлок", "Обмани меня", "Отбросы", "Чёрное зеркало", "Красные браслеты" };

	public Series() {
		super(triggers, series);
	}
	
	private static final String[] triggers =
		{
			"(?iu:сериал|сериальчик)",
			"(?iu:какой\\s.*сериал)",
			"(?iu:подскажи\\s.*сериал)",
			"(?iu:посоветуй\\s.*сериал)"
		};
}
