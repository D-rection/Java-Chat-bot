package answers;

import bot.AnswerData;
import bot.InputData;
import bot.TopicConversation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class PatternBasedConversation implements TopicConversation {

	private final List<Pattern> patterns;

	protected PatternBasedConversation(String[] patterns) {
		this.patterns = Arrays.stream(patterns).map(Pattern::compile).collect(Collectors.toList());
	}

	public abstract AnswerData getAnswerData(InputData data);

	public boolean isThisSuitableTrigger(String message) {
        for (Pattern pattern : patterns) {
            if (pattern.matcher(message).find()) {
                return true;
            }
        }
        return false;
    }
}
