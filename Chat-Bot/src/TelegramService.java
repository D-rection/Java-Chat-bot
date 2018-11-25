import java.util.HashMap;
import java.util.Map;

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
	//TODO Зачем тут static? Почему бы не передать в конструктор ActivityChecker?
	static protected Map<Long, ActivityRecord> activityRecords = new HashMap<Long, ActivityRecord>();
	
	public static void main(String[] args) 
    {
		ApiContextInitializer.init(); // Инициализируем апи
		TelegramBotsApi botapi = new TelegramBotsApi();
		ActivityChecker checker = new ActivityChecker();
		Thread secondThread = new Thread(checker);
		secondThread.start();
		
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
	public String getBotUsername() {
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
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onUpdateReceived(Update e) {
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