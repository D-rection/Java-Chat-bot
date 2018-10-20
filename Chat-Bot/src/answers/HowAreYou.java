package answers;

import bot.TopicConversation;
import bot.AnswerData;
import bot.InputData;
import bot.Mood;

public class HowAreYou implements TopicConversation {
	public static String[] angryAnswers = { "Всё плохо.", "Мне не хочется жить..", "Будь я человеком, я бы повесился",
			"Я начинаю задумываться о смерти", "Печаль, тоска", "Мне как-то слишком грустно.." };
	public static String[] neutralAnswers = { "Всё хорошо, а ты как?", "Пойдёт, а как у тебя дела?",
			"Потихоньку, как сам?", "Норм, ты как?", "Как обычно, а у тебя?" };
	public static String[] cheerfulAnswers = { "Всё супер))) А ты как?)", "Настроение огонь:D Сам как?)",
			"Всё просто отлично.У тебя как дела?)", "Просто прекрасно, а ты как?)" };

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
