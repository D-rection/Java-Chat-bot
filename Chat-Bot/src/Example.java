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

public class Example extends TelegramLongPollingBot
{
	private ChatBot chatBot = new ChatBot();
	
	public static void main(String[] args) 
    {
		ApiContextInitializer.init(); // Инициализируем апи
		TelegramBotsApi botapi = new TelegramBotsApi();
		try 
		{
			botapi.registerBot(new Example());
		} catch (TelegramApiException e) 
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
			execute(sndMsg);
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
			sendMessage(message, chatBot.sayInReturn(message.getText()));
		}
		// Тут будет то, что выполняется при получении сообщения
	}

	@Override
	public String getBotToken() {
		return "710673805:AAGLsqVGtbMg9284buAvtiSlhOO8lf1614M";
	}

}