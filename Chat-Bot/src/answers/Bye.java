package answers;

public class Bye extends TopicConversationBase {
	public static final String[] angryAnswers = { "Прощай, надеюсь больше не увидимся", "Пока, лучше больше не пиши мне",
			"Ну наконец-то, а то я так устал от общения с тобой", "Пока" };
	public static final String[] neutralAnswers = { "Пока, дружище. Рад был тебя видеть",
			"До встречи, надеюсь, что она будет очень скоро", "Пока. Удачи тебе:)" };
	public static final String[] cheerfulAnswers = { "Иди, но обещай вернуться:D", "Чао)))", "До скорой встречи, дружище)" };
	
	private static final String[] triggers =
		{
			"(?iu:прощай|пока|покеда|увидимся)",
			"(?iu:до\\s.*свидания)",
		};

	public Bye() {
		super(triggers, angryAnswers, neutralAnswers, cheerfulAnswers);
	}
}
