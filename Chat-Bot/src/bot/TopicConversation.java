package bot;

public interface TopicConversation {
	AnswerData getAnswerData(InputData data);
	default boolean isThisSuitableTrigger(String message) {
		return true;
	}
}