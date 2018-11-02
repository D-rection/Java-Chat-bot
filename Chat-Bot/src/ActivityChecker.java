import java.util.Date;
import java.util.HashMap;

public class ActivityChecker implements Runnable
{
	private HashMap<Long, ActivityRecord> listActivityUsers = null;
	
	public ActivityChecker(HashMap<Long, ActivityRecord> dict)
	{
		listActivityUsers = dict;
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
				 for(Long id: listActivityUsers.keySet())
				 { 
					 long difference =  timeControl
							 - listActivityUsers.get(id).TimeLastActivity;
					 difference = difference / (1000 * 60);
					 if(difference > 5)
						 listActivityUsers.remove(id);
				 }
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
	}	
}
