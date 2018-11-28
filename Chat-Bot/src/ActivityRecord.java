import java.util.Date;

import bot.ChatBot;

public class ActivityRecord 
{
	private long TimeLastActivity = 0;
	private ChatBot Bot = new ChatBot();

	public String GetAnswer(String sentence)
	{
		return Bot.sayInReturn(sentence);
	}
	
	public long GetTimeLastActivity()
	{
		return TimeLastActivity;
	}
	
	public void UpdateActivity()
	{
		TimeLastActivity = System.currentTimeMillis();
	}
	
	public ActivityRecord()
	{
		TimeLastActivity = System.currentTimeMillis();
		Bot = new ChatBot();
	}
}
