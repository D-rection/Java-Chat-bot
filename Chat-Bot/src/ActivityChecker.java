import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.*;

import Logger.Logger;
import Logger.Record;

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
				Thread.currentThread().sleep(5000);
				long timeControl = System.currentTimeMillis();
				 for(Long id: activityRecords.keySet())
				 { 
					 long difference =  timeControl
							 - activityRecords.get(id).GetTimeLastActivity();
					 difference = difference / (1000 * 60);
					 if(difference > 5)
					 {
						 String type = "Sleep User Cleaner";
						 String info = "Chat №" + id.toString() + " - remove"; 
						 log.AddRecord(new Record(type, info));
						 activityRecords.remove(id);
					 }
				 }
			} catch (InterruptedException e) 
			{
				String type = "Sleep User Cleaner";
				String info = e.getMessage(); 
				log.AddRecord(new Record(type, info));
			}
			
		}
	}	
}
