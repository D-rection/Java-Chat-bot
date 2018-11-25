import java.util.Date;
import java.util.HashMap;

public class ActivityChecker implements Runnable
{

	@Override
	public void run() 
	{
		//TODO К сожалению, обновлять HashMap из двух потоков чревато бесконечными циклами из-за потоконебезопасности. Попробуйте взять какую-нибудь потокобезопасную реализацию Map
		while(true)
		{
			try 
			{
				Thread.currentThread().sleep(5000);
				long timeControl = System.currentTimeMillis();
				 for(Long id: TelegramService.activityRecords.keySet())
				 { 
					 long difference =  timeControl
							 - TelegramService.activityRecords.get(id).GetTimeLastActivity();
					 difference = difference / (1000 * 60);
					 if(difference > 5)
						 TelegramService.activityRecords.remove(id);
				 }
			} catch (InterruptedException e) 
			{
				//TODO Вы используете лучшие практики по обработки исключений :)
				e.printStackTrace();
			}
			
		}
	}	
}
