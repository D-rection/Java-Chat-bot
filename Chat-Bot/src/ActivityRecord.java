import java.util.Date;

import bot.ChatBot;

public class ActivityRecord 
{
	//TODO У вас тут прямо сплошная инкапсуляция :)
	public long TimeLastActivity = 0;
	public ChatBot Bot = null;

	//TODO Метод не используется
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
