package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;
import bot.BaseTopicConversation;

public class Hello extends BaseTopicConversation implements TopicConversation {
	public static String[] angryAnswers = {
			"Привет, землянин:D Я чат-бот Макс. Чтобы узнать, что я могу, просто спроси: \"Что ты можешь?\"",
			"Приветик. Я Максимка. Спроси меня: \"Что ты можешь?\" и я тут же расскажу тебе о своих крутых навыках" };
	public static String[] neutralAnswers = {
			"Здравствуйте, меня зовут Максим. Если хотите узнать мои навыки, спросите \"Что ты можешь?\"",
			"Здравствуй, человек! Я дружелюбный бот Максим. Если хочешь узнать, что я умею, спроси: \"Что ты умеешь?\"" };
	public static String[] cheerfulAnswers = { "Привет, я Максим. Может ты уже спросишь меня: \"Что ты умеешь?\"" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerData(input, angryAnswers, neutralAnswers, cheerfulAnswers);
	}
}
