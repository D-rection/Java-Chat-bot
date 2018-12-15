package answers;

public class HowAreYou extends TopicConversationBase {
	public final static String[] angryAnswers = { "Всё плохо.", "Мне не хочется жить..", "Будь я человеком, я бы повесился",
			"Я начинаю задумываться о смерти", "Печаль, тоска", "Мне как-то слишком грустно.." };
	public final static String[] neutralAnswers = { "Всё хорошо, а ты как?", "Пойдёт, а как у тебя дела?",
			"Потихоньку, как сам?", "Норм, ты как?", "Как обычно, а у тебя?" };
	public final static String[] cheerfulAnswers = { "Всё супер))) А ты как?)", "Настроение огонь:D Сам как?)",
			"Всё просто отлично.У тебя как дела?)", "Просто прекрасно, а ты как?)" };


	private static final String[] triggers =
		{
			"(?iu:как\\s.*дела)",
			"(?iu:как\\s.*жизнь)"
		};

	public HowAreYou() {
		super(triggers, angryAnswers, neutralAnswers, cheerfulAnswers);
	}
}
