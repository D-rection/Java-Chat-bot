package answers;

public class Hello extends TopicConversationBase {
	public static final String[] angryAnswers = {
			"Привет, землянин:D Я чат-бот Макс. Чтобы узнать, что я могу, просто спроси: \"Что ты можешь?\"",
			"Приветик. Я Максимка. Спроси меня: \"Что ты можешь?\" и я тут же расскажу тебе о своих крутых навыках" };
	public static final String[] neutralAnswers = {
			"Здравствуйте, меня зовут Максим. Если хотите узнать мои навыки, спросите \"Что ты можешь?\"",
			"Здравствуй, человек! Я дружелюбный бот Максим. Если хочешь узнать, что я умею, спроси: \"Что ты умеешь?\"" };
	public static final String[] cheerfulAnswers = { "Привет, я Максим. Может ты уже спросишь меня: \"Что ты умеешь?\"" };

	public Hello() {
		super(triggers, angryAnswers, neutralAnswers, cheerfulAnswers);
	}
	
	private static final String[] triggers =
		{
			"(?iu:хай|привет|здорово|здравствуй|здаровки)"
		};
}
