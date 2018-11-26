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

import bot.ChatBot;

public class TelegramService extends TelegramLongPollingBot
{
	private ConcurrentHashMap<Long, ActivityRecord> activityRecords = 
			new ConcurrentHashMap<Long, ActivityRecord>();
	private ActivityChecker checker = new ActivityChecker(activityRecords);
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
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onUpdateReceived(Update e) 
	{
		if (!startSecondThread)
		{
			secondThread.start();
			startSecondThread = true;
		}
		Message message = e.getMessage();
		if (message != null && message.hasText())
		{
			if (!activityRecords.containsKey(message.getChatId()))				
				activityRecords.put(message.getChatId(), new ActivityRecord());
			activityRecords.get(message.getChatId()).UpdateActivity();
			sendMessage(message, activityRecords.get(message.getChatId()).Bot
					.sayInReturn(message.getText()));
		}
	}

	@Override
	public String getBotToken() {
		return "710673805:AAGLsqVGtbMg9284buAvtiSlhOO8lf1614M";
	}

}