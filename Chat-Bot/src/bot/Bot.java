/**
 * Class Bot
 *
 * @author Tatyana
 */
package bot;

import java.util.*;
import java.util.regex.*;

public class Bot {
	private Random random = new Random(); // Для рандомных ответов
	private Attitude attitude = new Attitude();
	private Memory memory = new Memory();
	private TopicConversation currentConversation = null;
	private InputData input = new InputData(null, null);
	
	

	private void updateInputData(String userAnswer) {
		input = new InputData(attitude, userAnswer);
	}

	public String sayInReturn(String msg) {
		updateInputData(msg);
		String say = (msg.trim().endsWith("?")) ? memory.ELUSIVE_ANSWERS[random.nextInt(memory.ELUSIVE_ANSWERS.length)]
				: memory.COMMON_PHRASES[random.nextInt(memory.COMMON_PHRASES.length)];
		if (currentConversation != null) {
			AnswerData data = currentConversation.getAnswerData(input);
			if (!data.saveTheme())
				currentConversation = null;
			updateInputData(data.getAnswer());
			return data.getAnswer();
		}

		String message = String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
		for (String stringKey : memory.patternsForAnalysis.keySet()) {
			Pattern pattern = Pattern.compile(stringKey);
			if (pattern.matcher(message).find()) {
				AnswerData data = memory.patternsForAnalysis.get(stringKey)
						.getAnswerData(input);
				if (!data.saveTheme())
					currentConversation = null;
				else if (currentConversation == null)
					currentConversation = memory.patternsForAnalysis.get(stringKey);
				updateInputData(data.getAnswer());
				return data.getAnswer();
			}
		}
		updateInputData(say);
		return say;
	}
}