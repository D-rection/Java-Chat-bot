package answers;

import bot.TopicConversation;

import java.util.HashSet;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;

public class HowAreYou extends BaseTopicConversation implements TopicConversation {
	public String[] angryAnswers = { "Всё плохо.", "Мне не хочется жить..", "Будь я человеком, я бы повесился",
			"Я начинаю задумываться о смерти", "Печаль, тоска", "Мне как-то слишком грустно.." };
	public String[] neutralAnswers = { "Всё хорошо, а ты как?", "Пойдёт, а как у тебя дела?",
			"Потихоньку, как сам?", "Норм, ты как?", "Как обычно, а у тебя?" };
	public String[] cheerfulAnswers = { "Всё супер))) А ты как?)", "Настроение огонь:D Сам как?)",
			"Всё просто отлично.У тебя как дела?)", "Просто прекрасно, а ты как?)" };

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerData(input, angryAnswers, neutralAnswers, cheerfulAnswers);
	}

	private HashSet<Pattern> triggers = new HashSet<Pattern>() 
	{
		{
			add(Pattern.compile("(?iu:как\\s.*дела)"));
			add(Pattern.compile("(?iu:как\\s.*жизнь)"));
		}
	};
	
	@Override
	public HashSet<Pattern> getTriggers() {
		return (HashSet<Pattern>) triggers.clone();
	}
}
