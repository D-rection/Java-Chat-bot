import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import Logger.Logger;
import Logger.Record;
import bot.ChatBot;

public class TelegramService extends TelegramLongPollingBot
{
	private ConcurrentHashMap<Long, ActivityRecord> activityRecords = 
			new ConcurrentHashMap<Long, ActivityRecord>();
	private Logger log = new Logger("src/files/log.txt");
	private ActivityChecker checker = new ActivityChecker(activityRecords, log);
	private Thread secondThread = new Thread(checker);
	private boolean startSecondThread = false;
	
	public static void main(String[] args) 
    {
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
			String type = "Telegram Service";
			String info = "Bot answer user " + msg.getChatId();
			log.AddRecord(new Record(type, info));
		} catch (Exception e)
		{
			String type = "Telegram Service";
			String info = e.getMessage();
			log.AddRecord(new Record(type, info));
		}
	}

	@Override
	public void onUpdateReceived(Update e) 
	{
		if (!startSecondThread)
		{
			String type = "Telegram Service";
			String info = "############START#############";
			log.AddRecord(new Record(type, info));
			secondThread.start();
			startSecondThread = true;
		}
		Message message = e.getMessage();
		if (message != null && message.hasText())
		{
			if (!activityRecords.containsKey(message.getChatId()))
			{
				String type = "Telegram Service";
				String info = "New user with ChatID:" + message.getChatId();
				log.AddRecord(new Record(type, info));
				activityRecords.put(message.getChatId(), new ActivityRecord());
			}
			activityRecords.get(message.getChatId()).UpdateActivity();
			String type = "Telegram Service";
			String info = "Update time activity.ChatID:" + message.getChatId();
			log.AddRecord(new Record(type, info));
			sendMessage(message, activityRecords.get(message.getChatId())
					.GetAnswer(message.getText()));
		}
	}

	@Override
	public String getBotToken() {
		return "710673805:AAGLsqVGtbMg9284buAvtiSlhOO8lf1614M";
	}

}