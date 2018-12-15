package answers;

import bot.TopicConversation;
import java.util.HashSet;
import java.util.regex.Pattern;
import bot.AnswerData;
import bot.InputData;

public class Bye extends BaseTopicConversation implements TopicConversation {
	public String[] angryAnswers = { "Прощай, надеюсь больше не увидимся", "Пока, лучше больше не пиши мне",
			"Ну наконец-то, а то я так устал от общения с тобой", "Пока" };
	public String[] neutralAnswers = { "Пока, дружище. Рад был тебя видеть",
			"До встречи, надеюсь, что она будет очень скоро", "Пока. Удачи тебе:)" };
	public String[] cheerfulAnswers = { "Иди, но обещай вернуться:D", "Чао)))", "До скорой встречи, дружище)" };
	
	private HashSet<Pattern> triggers = new HashSet<Pattern>() {
		{
			add(Pattern.compile("(?iu:прощай|пока|покеда|увидимся)")); 		 
			add(Pattern.compile("(?iu:до\\s.*свидания)")); 
		}
	};

	public AnswerData getAnswerData(InputData input) {
		return super.getAnswerData(input, angryAnswers, neutralAnswers, cheerfulAnswers);
	}

	@Override
	public HashSet<Pattern> getTriggers() {
		return (HashSet<Pattern>) triggers.clone();
	}
}
