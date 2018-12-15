import java.io.IOException;
import java.util.concurrent.*;
import java.util.logging.*;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramService extends TelegramLongPollingBot
{
	private ConcurrentHashMap<Long, ActivityRecord> activityRecords = 
			new ConcurrentHashMap<Long, ActivityRecord>();
	private static Logger log = Logger.getLogger(TelegramService.class.getName());
	private ActivityChecker checker = new ActivityChecker(activityRecords, log);
	private Thread secondThread = new Thread(checker);
	private boolean startSecondThread = false;
	
	private static void loggerInit()
	{
		FileHandler fh;  

	    try {  
	        fh = new FileHandler("log.txt");  
	        log.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);   

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
	}
	
	public static void main(String[] args) 
    {
		loggerInit();
		ApiContextInitializer.init(); // Инициализируем апи
		TelegramBotsApi botapi = new TelegramBotsApi();	
		try 
		{
			botapi.registerBot(new TelegramService());
		}
		catch (TelegramApiException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public String getBotUsername() 
	{
		return "FriendlyMaxbot";
	}
	
	public void sendMessage(Message msg, String text)
	{
		SendMessage sndMsg = new SendMessage();
		sndMsg.enableMarkdown(true);
		sndMsg.setChatId(msg.getChatId());
		sndMsg.setText(text);
		try
		{
			execute(sndMsg);
			String info = "Bot answer user " + msg.getChatId();
			log.info(info);;
		} catch (Exception e)
		{
			String info = e.getMessage();
			log.info(info);
		}
	}

	@Override
	public void onUpdateReceived(Update e) 
	{
		if (!startSecondThread)
		{
			String info = "############START#############";
			log.info(info);
			secondThread.start();
			startSecondThread = true;
		}
		Message message = e.getMessage();
		if (message != null && message.hasText())
		{
			if (!activityRecords.containsKey(message.getChatId()))
			{
				String info = "New user with ChatID:" + message.getChatId();
				log.info(info);
				activityRecords.put(message.getChatId(), new ActivityRecord());
			}
			activityRecords.get(message.getChatId()).UpdateActivity();
			String info = "Update time activity.ChatID:" + message.getChatId();
			log.info(info);
			sendMessage(message, activityRecords.get(message.getChatId())
					.GetAnswer(message.getText()));
		}
	}

	@Override
	public String getBotToken() {
		return "710673805:AAGLsqVGtbMg9284buAvtiSlhOO8lf1614M";
	}

}