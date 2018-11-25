package bot;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import answers.*;
import numbers.*;
import towns.TownsGame;

//TODO В ообщем и целом, надо разобрать этот класс совсем. Подумайте, куда и как лучше убрать COMMON_PHRASES и ELUSIVE_ANSWERS
public class Memory {
	final String[] COMMON_PHRASES = { "Нет ничего ценнее слов, сказанных к месту и ко времени.",
			"Порой молчание может сказать больше, нежели уйма слов.",
			"Перед тем как писать/говорить всегда лучше подумать.", "Вежливая и грамотная речь говорит о величии души.",
			"Приятно когда текст без орфографических ошибок.", "Многословие есть признак неупорядоченного ума.",
			"Слова могут ранить, но могут и исцелять.", "Записывая слова, мы удваиваем их силу.",
			"Кто ясно мыслит, тот ясно излагает.", "Боюсь Вы что-то не договариваете." };
	final String[] ELUSIVE_ANSWERS = { "Вопрос непростой, прошу тайм-аут на раздумья.",
			"Не уверен, что располагаю такой информацией.", "Может лучше поговорим о чём-то другом?",
			"Простите, но это очень личный вопрос.", "Не уверен, что Вам понравится ответ.",
			"Поверьте, я сам хотел бы это знать.", "Вы действительно хотите это знать?",
			"Уверен, Вы уже догадались сами.", "Зачем Вам такая информация?", "Давайте сохраним интригу?" };

	//TODO Вот эти вот паттерны я бы так же перенес в соответствующие TopicConversation
	Map<Pattern, NameTopics> patternsForAnalysis = new HashMap<Pattern, NameTopics>() {
		{
			// hello
			put(Pattern.compile("хай"), NameTopics.Hello);
			put(Pattern.compile("привет"), NameTopics.Hello);
			put(Pattern.compile("здорово"), NameTopics.Hello);
			put(Pattern.compile("здравствуй"), NameTopics.Hello);
			put(Pattern.compile("здаровки"), NameTopics.Hello);
			// whatcan
			put(Pattern.compile("что\\s.*можешь"),  NameTopics.WhatCan);
			put(Pattern.compile("что\\s.*умеешь"),  NameTopics.WhatCan);
			// howareyou
			put(Pattern.compile("как\\s.*дела"), NameTopics.HowAreYou);
			put(Pattern.compile("как\\s.*жизнь"), NameTopics.HowAreYou);
			// whatareyoudoing
			put(Pattern.compile("зачем\\s.*тут"), NameTopics.WhatAreYouDoing);
			put(Pattern.compile("зачем\\s.*здесь"), NameTopics.WhatAreYouDoing);
			put(Pattern.compile("что\\s.*делаешь"), NameTopics.WhatAreYouDoing);
			put(Pattern.compile("чем\\s.*занимаешься"), NameTopics.WhatAreYouDoing);
			put(Pattern.compile("что\\s.*творишь"), NameTopics.WhatAreYouDoing);
			put(Pattern.compile("чем\\s.*занят"), NameTopics.WhatAreYouDoing);
			// whatday
			put(Pattern.compile("какой\\s.*день"), NameTopics.WhatDay);
			put(Pattern.compile("какое\\s.*число"), NameTopics.WhatDay);
			put(Pattern.compile("какой\\\\s.*день"), NameTopics.WhatDay);
			put(Pattern.compile("какой\\\\s.*число"), NameTopics.WhatDay);
			// whattime
			put(Pattern.compile("который\\s.*час"), NameTopics.WhatTime);
			put(Pattern.compile("сколько\\s.*время"), NameTopics.WhatTime);
			// bye
			put(Pattern.compile("прощай"), NameTopics.Bye);
			put(Pattern.compile("пока"), NameTopics.Bye);
			put(Pattern.compile("покеда"), NameTopics.Bye);
			put(Pattern.compile("увидимся"), NameTopics.Bye);
			put(Pattern.compile("до\\s.*свидания"), NameTopics.Bye);
			// whatwatch
			put(Pattern.compile("что\\s.*посмотреть"), NameTopics.WhatWatch);
			put(Pattern.compile("что\\s.глянуть"), NameTopics.WhatWatch);
			// cartoon
			put(Pattern.compile("мультфильм"), NameTopics.Cartoon);
			put(Pattern.compile("мультик"), NameTopics.Cartoon);
			put(Pattern.compile("какой\\s.*мультфильм"), NameTopics.Cartoon);
			put(Pattern.compile("подскажи\\s.*мультфильм"), NameTopics.Cartoon);
			put(Pattern.compile("посоветуй\\s.*мультфильм"), NameTopics.Cartoon);
			// film
			put(Pattern.compile("фильм"), NameTopics.Film);
			put(Pattern.compile("фильмец"), NameTopics.Film);
			put(Pattern.compile("какой\\s.*фильм"), NameTopics.Film);
			put(Pattern.compile("подскажи\\s.*фильм"), NameTopics.Film);
			put(Pattern.compile("посоветуй\\s.*фильм"), NameTopics.Film);
			// series
			put(Pattern.compile("сериал"), NameTopics.Series);
			put(Pattern.compile("сериальчик"), NameTopics.Series);
			put(Pattern.compile("какой\\s.*сериал"), NameTopics.Series);
			put(Pattern.compile("подскажи\\s.*сериал"), NameTopics.Series);
			put(Pattern.compile("посоветуй\\s.*сериал"), NameTopics.Series);
			// towns
			put(Pattern.compile("города"), NameTopics.TownsGame);
			// numbers
			put(Pattern.compile("поиграем\\s.*числа"), NameTopics.PlayNumbers);
			put(Pattern.compile("сыграем\\s.*числа"), NameTopics.PlayNumbers);
			put(Pattern.compile("отгадывать"), NameTopics.PlayNumbers);
			put(Pattern.compile("загадывать"), NameTopics.PlayNumbers);
			//translate service
			put(Pattern.compile("переведи"), NameTopics.TranslateService);
			put(Pattern.compile("можешь\\s.*перевести"), NameTopics.TranslateService);
			put(Pattern.compile("переводчик"), NameTopics.TranslateService);
		}
	};
}
