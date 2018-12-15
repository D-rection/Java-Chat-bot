package answers;

import bot.AnswerData;
import bot.InputData;

public class TopicConversationBase extends PatternBasedConversation {
	private String[] angry;
	private String[] neutral;
	private String[] cheerful;

	protected TopicConversationBase(String[] patterns, String[] angry, String[] neutral, String[] cheerful) {
		super(patterns);
		this.angry = angry;
		this.neutral = neutral;
		this.cheerful = cheerful;
	}

	@Override
	public AnswerData getAnswerData(InputData input) {
		String[] answers = input.currentAttitude.isAngry()
				? angry
				: input.currentAttitude.isNeutral()
					? neutral
					: cheerful;
		return new AnswerData(RandomHelpers.pickRandom(answers), false);
	}
}
