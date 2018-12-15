package answers;

public class WhatWatch extends TopicConversationBase {
	private static final String[] triggers =
		{
			"(?iu:что\\s.*посмотреть)",
			"(?iu:что\\s.глянуть)"
		};

	public static final String[] angryAnswers = { "Сам ищи", "Я не хочу тебе помогать", "Смотри, что хочешь", "Лень искать",
			"Давай как-нибудь сам" };
	public static final String[] neutralAnswers = { "Что ты хочешь посмотреть: фильм, мультфильм или сериал?" };

	public WhatWatch() {
		super(triggers, angryAnswers, neutralAnswers, neutralAnswers);
	}
}
