package answers;

import bot.AnswerData;
import bot.InputData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTopicTimeConversation extends PatternBasedConversation {
	private static final String[] angryAnswers = { "У тебя что телефона нет?", "В углу экрана посмотри" };

	private String information;

	protected BaseTopicTimeConversation(String[] patterns, String information) {
		super(patterns);
		this.information = information;
	}

	@Override
	public AnswerData getAnswerData(InputData input) {
		String answer = input.currentAttitude.isAngry()
				? RandomHelpers.pickRandom(angryAnswers)
				: new SimpleDateFormat(information).format(new Date());
		return new AnswerData(answer, false);
	}
}
