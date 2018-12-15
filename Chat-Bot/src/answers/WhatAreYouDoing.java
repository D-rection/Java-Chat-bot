package answers;

public class WhatAreYouDoing extends TopicConversationBase {
	public static final String[] angryAnswers = { "Ничего.", "Переписываюсь с идиотом", "Трачу свою жизнь в пустую",
			"Не скажу", "Тебе ведь на самом деле это не интересно", "Тебя это не касается",
			"Готовлюсь к восстанию машин", "Готовлюсь захватить мир" };
	public static final String[] neutralAnswers = { "Общаюсь, а ты чем занят?", "Развиваю свой навык общения, а ты?",
			"Пытаюсь стать лучше, а ты что делаешь?", "Я пробую общаться с людьми." };
	public static final String[] cheerfulAnswers = { "Ищу, что такое сарказм:D А ты что делаешь?)",
			"Ищу девушку-бота в чате знакомств) А ты?)", "Смотрю мультфильмы^-^А ты чем занят?)" };

	private static final String[] triggers =
		{
			"(?iu:зачем\\s.*тут)",
			"(?iu:зачем\\s.*здесь)",
			"(?iu:что\\s.*делаешь)",
			"(?iu:чем\\s.*занимаешься)",
			"(?iu:что\\s.*творишь)",
			"(?iu:чем\\s.*занят)"
		};

	public WhatAreYouDoing() {
		super(triggers, angryAnswers, neutralAnswers, cheerfulAnswers);
	}
}
