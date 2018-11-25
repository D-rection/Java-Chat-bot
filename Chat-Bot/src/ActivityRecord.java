import java.util.Date;

import bot.ChatBot;

public class ActivityRecord 
{
	//TODO У вас тут прямо сплошная инкапсуляция :)
	private long TimeLastActivity = 0;
	public ChatBot Bot = null;

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
