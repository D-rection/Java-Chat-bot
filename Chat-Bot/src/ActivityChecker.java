import java.util.concurrent.*;
import java.util.logging.*;

public class ActivityChecker implements Runnable
{
	private ConcurrentHashMap<Long, ActivityRecord> activityRecords = 
			new ConcurrentHashMap<Long, ActivityRecord>();
	private Logger log;
	
	public ActivityChecker(ConcurrentHashMap<Long, ActivityRecord> records, Logger lg)
	{
		activityRecords = records;
		log = lg;
	}

	@Override
	public void run() 
	{
		while(true)
		{
			try 
			{
				Thread.currentThread().sleep(250);
				long timeControl = System.currentTimeMillis();
				 for(Long id: activityRecords.keySet())
				 { 
					 long difference =  timeControl
							 - activityRecords.get(id).GetTimeLastActivity();
					 difference = difference / (1000 * 60);
					 if(difference > 5)
					 {
						 String info = "Chat №" + id.toString() + " - remove"; 
						 log.info(info);
						 activityRecords.remove(id);
					 }
				 }
			} catch (InterruptedException e) 
			{
				String info = e.getMessage(); 
				log.info(info);
			}
			
		}
	}	
}
