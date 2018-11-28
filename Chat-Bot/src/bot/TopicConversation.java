package bot;

import java.util.HashSet;
import java.util.regex.Pattern;

public interface TopicConversation {
	AnswerData getAnswerData(InputData data);	
	HashSet<Pattern> getTriggers();
	
	public default boolean isThisSuitableTrigger(String message, HashSet<Pattern> triggers)
	{
		boolean result = false;
		for (Pattern key: triggers)
		{
			if (key.matcher(message).find())
			{
				result = true;
				break;
			}
		}
		return result;
	}
}