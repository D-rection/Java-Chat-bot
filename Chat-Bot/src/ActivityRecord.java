import java.util.Date;

import bot.ChatBot;

public class ActivityRecord 
{
	public long TimeLastActivity = 0;
	public ChatBot Bot = null;
	
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
