package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;
import bot.Mood;

public class Bye implements TopicConversation {

	public static String[] angryAnswers = { "Прощай, надеюсь больше не увидимся", "Пока, лучше больше не пиши мне",
			"Ну наконец-то, а то я так устал от общения с тобой", "Пока" };
	public static String[] neutralAnswers = { "Пока, дружище. Рад был тебя видеть",
			"До встречи, надеюсь, что она будет очень скоро", "Пока. Удачи тебе:)" };
	public static String[] cheerfulAnswers = { "Иди, но обещай вернуться:D", "Чао)))", "До скорой встречи, дружище)" };

	public AnswerData getAnswerData(InputData input) {
		if (input.currentAttitude.getFriendliness() == Mood.Angry) {
			int random = 0 + (int) (Math.random() * angryAnswers.length);
			return new AnswerData(angryAnswers[random], false);
		} else if (input.currentAttitude.getFriendliness() == Mood.Neutral) {
			int random = 0 + (int) (Math.random() * neutralAnswers.length);
			return new AnswerData(neutralAnswers[random], false);
		} else {
			int random = 0 + (int) (Math.random() * cheerfulAnswers.length);
			return new AnswerData(cheerfulAnswers[random], false);
		}
	}
}
