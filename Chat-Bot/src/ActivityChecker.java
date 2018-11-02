import java.util.Date;
import java.util.HashMap;

public class ActivityChecker implements Runnable
{
	public ActivityChecker()
	{
		
	}

	@Override
	public void run() 
	{
		while(true)
		{
			try 
			{
				Thread.currentThread().sleep(5000);
				long timeControl = System.currentTimeMillis();
				 for(Long id: TelegramService.activityRecords.keySet())
				 { 
					 long difference =  timeControl
							 - TelegramService.activityRecords.get(id).TimeLastActivity;
					 difference = difference / (1000 * 60);
					 if(difference > 5)
						 TelegramService.activityRecords.remove(id);
				 }
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
	}	
}
