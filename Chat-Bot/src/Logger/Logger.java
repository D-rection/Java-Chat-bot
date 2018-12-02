package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

//TODO Круто, что вы написали это руками, а теперь, пожалуйста, возьмите что-то готовое :-/
public class Logger 
{
	private String logFilePath;
	private ArrayBlockingQueue<Record> queueRecords;
	private WriterLog writer;
	private Thread writeThread;
	
	public Logger(String path)
	{
		logFilePath = path;
		queueRecords = new ArrayBlockingQueue<Record>(50);
		writer = new WriterLog(queueRecords, path);
		writeThread = new Thread(writer);		
		writeThread.start();
	}
	
	public void AddRecord(Record rec)
	{	
		queueRecords.add(rec);
	}	
}
