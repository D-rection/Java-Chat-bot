/**
 * Class Bot
 *
 * @author Tatyana
 */
package bot;

import java.util.*;
import java.util.regex.*;

import answers.Bye;
import answers.Cartoon;
import answers.Film;
import answers.Hello;
import answers.HowAreYou;
import answers.Series;
import answers.WhatAreYouDoing;
import answers.WhatCan;
import answers.WhatDay;
import answers.WhatTime;
import answers.WhatWatch;
import numbers.PlayNumbers;
import towns.TownsGame;

public class Bot {
	private Random random = new Random(); // Для рандомных ответов
	private Attitude attitude = new Attitude();
	private Memory memory = new Memory();
	private TopicConversation currentConversation = null;
	private InputData input = new InputData(null, null);
	
	private TopicConversation[] topics = new TopicConversation[100];

	private void updateInputData(String userAnswer) {
		input = new InputData(attitude, userAnswer);
	}
	
	public Bot()
	{
		topics[NameTopics.WhatCan.ordinal()] = new WhatCan();
		topics[NameTopics.Bye.ordinal()] =  new Bye();
		topics[NameTopics.Cartoon.ordinal()] = new Cartoon();
		topics[NameTopics.Film.ordinal()] = new Film();
		topics[NameTopics.Hello.ordinal()] = new Hello();
		topics[NameTopics.HowAreYou.ordinal()] = new HowAreYou();
		topics[NameTopics.PlayNumbers.ordinal()] = new PlayNumbers();		
		topics[NameTopics.WhatAreYouDoing.ordinal()] = new WhatAreYouDoing();		
		topics[NameTopics.WhatDay.ordinal()] = new WhatDay();
		topics[NameTopics.WhatTime.ordinal()] = new WhatTime();
		topics[NameTopics.WhatWatch.ordinal()] = new WhatWatch();
		topics[NameTopics.Series.ordinal()] = new Series();
		topics[NameTopics.TownsGame.ordinal()] = new TownsGame();
	}
	
	public String sayInReturn(String msg) {
		updateInputData(msg);
		String say = (msg.trim().endsWith("?")) ? memory.ELUSIVE_ANSWERS[random.nextInt(memory.ELUSIVE_ANSWERS.length)]
				: memory.COMMON_PHRASES[random.nextInt(memory.COMMON_PHRASES.length)];
		if (currentConversation != null) {
			AnswerData data = currentConversation.getAnswerData(input);
			if (!data.saveTheme())
				currentConversation = null;
			updateInputData(data.getAnswer());
			return data.getAnswer();
		}

		String message = String.join(" ", msg.toLowerCase().split("[ {,|.}?]+"));
		for (String stringKey : memory.patternsForAnalysis.keySet()) {
			Pattern pattern = Pattern.compile(stringKey);
			if (pattern.matcher(message).find()) {
				AnswerData data = topics[memory.patternsForAnalysis.get(stringKey).ordinal()]
						.getAnswerData(input);
				if (!data.saveTheme())
					currentConversation = null;
				else if (currentConversation == null)
					currentConversation =topics[memory.patternsForAnalysis
					                            .get(stringKey).ordinal()];
				updateInputData(data.getAnswer());
				return data.getAnswer();
			}
		}
		updateInputData(say);
		return say;
	}
}