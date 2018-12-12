package answers;

import bot.TopicConversation;

import java.util.HashSet;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;

public class Hello extends BaseTopicConversation implements TopicConversation {
	public String[] angryAnswers = {
			"Привет, землянин:D Я чат-бот Макс. Чтобы узнать, что я могу, просто спроси: \"Что ты можешь?\"",
			"Приветик. Я Максимка. Спроси меня: \"Что ты можешь?\" и я тут же расскажу тебе о своих крутых навыках" };
	public String[] neutralAnswers = {
			"Здравствуйте, меня зовут Максим. Если хотите узнать мои навыки, спросите \"Что ты можешь?\"",
			"Здравствуй, человек! Я дружелюбный бот Максим. Если хочешь узнать, что я умею, спроси: \"Что ты умеешь?\"" };
	public String[] cheerfulAnswers = { "Привет, я Максим. Может ты уже спросишь меня: \"Что ты умеешь?\"" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerData(input, angryAnswers, neutralAnswers, cheerfulAnswers);
	}
	
	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{
			add(Pattern.compile("(?iu:хай|привет|здорово|здравствуй|здаровки)"));
		}
	};

	@Override
	public HashSet<Pattern> getTriggers() {
		return (HashSet<Pattern>) triggers.clone();
	}
	
}
