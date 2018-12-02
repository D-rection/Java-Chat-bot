package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class WriterLog implements Runnable
{
	private ArrayBlockingQueue<Record> queueRecords = new ArrayBlockingQueue<Record>(50);
	private String logFilePath;
	
	public WriterLog(ArrayBlockingQueue<Record> quene, String path)
	{
		queueRecords = quene;
		logFilePath = path;
		
	}
	@Override
	public void run() 
	{
		while(true)
		{
			//TODO А зачем два вложенный while?!
			while(queueRecords.peek() != null)
			{
				Record rec = null;
				try 
				{
					rec = queueRecords.take();
				} catch (InterruptedException e) 
				{
					//TODO Из-за того, что вы таким способ обрабатывается исключение, то следующее обращение разлетится с NullPointer
				}

				try(FileWriter writer = new FileWriter(logFilePath, true))
				{
					writer.write(rec.ToStringOnRecord());
				}
				catch(IOException ex)
				{             
					System.out.println(ex.getMessage());
				} 
			}
		}
	}

}
