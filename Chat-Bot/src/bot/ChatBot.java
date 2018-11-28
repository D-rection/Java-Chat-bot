/**
 * Class Bot
 *
 * @author Tatyana
 */
package bot;

import java.util.*;
import java.util.regex.*;

import Translator.TranslateService;
import answers.Bye;
import answers.Cartoon;
import answers.Film;
import answers.Hello;
import answers.HowAreYou;
import answers.MeaninglessAnswers;
import answers.Series;
import answers.WhatAreYouDoing;
import answers.WhatCan;
import answers.WhatDay;
import answers.WhatTime;
import answers.WhatWatch;
import numbers.PlayNumbers;
import towns.TownsGame;

public class ChatBot {
	private Random random = new Random(); // Для рандомных ответов
	private Attitude attitude = new Attitude();
	private TopicConversation currentConversation = null;
	private InputData input = new InputData(null, null);

	private ArrayList<TopicConversation> topics = new ArrayList<TopicConversation>();

	private void updateInputData(String userAnswer) {
		input = new InputData(attitude, userAnswer);
	}

	public ChatBot()
	{
		topics.add(new WhatCan());
		topics.add(new Bye());
		topics.add(new Cartoon());
		topics.add(new Film());
		topics.add(new Hello());
		topics.add(new HowAreYou());
		topics.add(new PlayNumbers());		
		topics.add(new WhatAreYouDoing());		
		topics.add(new WhatDay());
		topics.add(new WhatTime());
		topics.add(new WhatWatch());
		topics.add(new Series());
		topics.add(new TownsGame());
		topics.add(new TranslateService());
		topics.add(new MeaninglessAnswers());
	}
	
	public String sayInReturn(String msg) {
		updateInputData(msg);
		if (currentConversation != null) {
			AnswerData data = currentConversation.getAnswerData(input);
			if (!data.saveTheme())
				currentConversation = null;
			updateInputData(data.getAnswer());
			return data.getAnswer();
		}
		String message = String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
		//TODO Вместо toLowerCase можно сделать регулярные выражения нечувствиительными к регистру
		//Объясните, почему это плохо. Мне не понятно
		for (TopicConversation topic : topics) {
			if (topic.isThisSuitableTrigger(message, topic.getTriggers())) 
			{
				AnswerData data = topic.getAnswerData(input);
				if (!data.saveTheme())
					currentConversation = null;
				else if (currentConversation == null)
					currentConversation = topic;
				updateInputData(data.getAnswer());
				return data.getAnswer();
			}
		}
		return null;
	}
}