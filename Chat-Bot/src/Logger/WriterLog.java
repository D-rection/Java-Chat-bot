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
			while(queueRecords.peek() != null)
			{
				Record rec = null;
				try 
				{
					rec = queueRecords.take();
				} catch (InterruptedException e) 
				{

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
