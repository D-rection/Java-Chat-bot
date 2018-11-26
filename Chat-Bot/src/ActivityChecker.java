import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.*;

public class ActivityChecker implements Runnable
{
	private ConcurrentHashMap<Long, ActivityRecord> activityRecords = 
			new ConcurrentHashMap<Long, ActivityRecord>();
	
	public ActivityChecker(ConcurrentHashMap<Long, ActivityRecord> records)
	{
		activityRecords = records;
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
				 for(Long id: activityRecords.keySet())
				 { 
					 long difference =  timeControl
							 - activityRecords.get(id).GetTimeLastActivity();
					 difference = difference / (1000 * 60);
					 if(difference > 5)
						 activityRecords.remove(id);
				 }
			} catch (InterruptedException e) 
			{
				//TODO Вы используете лучшие практики по обработки исключений :)
				e.printStackTrace();
			}
			
		}
	}	
}
