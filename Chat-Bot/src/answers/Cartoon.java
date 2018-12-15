package answers;

public class Cartoon extends BaseFilmTopicConversation {
	private static final String[] triggers = {
			"(?iu:мультфильм|мультик|мульт)",
			"(?iu:какой\\s.*мультфильм)",
			"(?iu:подскажи\\s.*мультфильм)",
			"(?iu:посоветуй\\s.*мультфильм)"
		};

	private static String[] cartoons = { "Переменная облачность", "Зверополис", "Как приручить дракона", "Вверх'",
			"Рапунцель:Запутанная история", "Маленький принц", "Хранители снов", "Холодное сердце", "Моана", "Гадкий я",
			"Мегамозг", "Семейка Крудс", "Университет монстров", "Монстры на каникулах", "Кот в сапогах:Три чертёнка",
			"Кунг-фу панда", "Ледниковый период", "Мадагаскар", "Шрек", "Тачки", "Книга джунглей", "Феи",
			"Монстр в париже", "Рио", "Ранго", "Фердинанд", "Вольт", "Принцесса и лягушка", "Дом", "Храбрая сердцем" };

	public Cartoon() {
		super(triggers, cartoons);
	}

}
