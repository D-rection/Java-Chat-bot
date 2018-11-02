package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;

public class Bye extends BaseTopicConversation implements TopicConversation {
	public static String[] angryAnswers = { "Прощай, надеюсь больше не увидимся", "Пока, лучше больше не пиши мне",
			"Ну наконец-то, а то я так устал от общения с тобой", "Пока" };
	public static String[] neutralAnswers = { "Пока, дружище. Рад был тебя видеть",
			"До встречи, надеюсь, что она будет очень скоро", "Пока. Удачи тебе:)" };
	public static String[] cheerfulAnswers = { "Иди, но обещай вернуться:D", "Чао)))", "До скорой встречи, дружище)" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerData(input, angryAnswers, neutralAnswers, cheerfulAnswers);
	}
}
