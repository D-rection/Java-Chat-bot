package bot;

import java.util.HashMap;
import java.util.Map;
import answers.*;
import numbers.*;
import towns.TownsGame;

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
	Map<String, NameTopics> patternsForAnalysis = new HashMap<String, NameTopics>() {
		{
			// hello
			put("хай", NameTopics.Hello);
			put("привет", NameTopics.Hello);
			put("здорово", NameTopics.Hello);
			put("здравствуй", NameTopics.Hello);
			put("здаровки", NameTopics.Hello);
			// whatcan
			put("что\\s.*можешь",  NameTopics.WhatCan);
			put("что\\s.*умеешь",  NameTopics.WhatCan);
			// howareyou
			put("как\\s.*дела", NameTopics.HowAreYou);
			put("как\\s.*жизнь", NameTopics.HowAreYou);
			// whatareyoudoing
			put("зачем\\s.*тут", NameTopics.WhatAreYouDoing);
			put("зачем\\s.*здесь", NameTopics.WhatAreYouDoing);
			put("что\\s.*делаешь", NameTopics.WhatAreYouDoing);
			put("чем\\s.*занимаешься", NameTopics.WhatAreYouDoing);
			put("что\\s.*творишь", NameTopics.WhatAreYouDoing);
			put("чем\\s.*занят", NameTopics.WhatAreYouDoing);
			// whatday
			put("какой\\s.*день", NameTopics.WhatDay);
			put("какое\\s.*число", NameTopics.WhatDay);
			put("какой\\\\s.*день", NameTopics.WhatDay);
			put("какой\\\\s.*число", NameTopics.WhatDay);
			// whattime
			put("который\\s.*час", NameTopics.WhatTime);
			put("сколько\\s.*время", NameTopics.WhatTime);
			// bye
			put("прощай", NameTopics.Bye);
			put("пока", NameTopics.Bye);
			put("покеда", NameTopics.Bye);
			put("увидимся", NameTopics.Bye);
			put("до\\s.*свидания", NameTopics.Bye);
			// whatwatch
			put("что\\s.*посмотреть", NameTopics.WhatWatch);
			put("что\\s.глянуть", NameTopics.WhatWatch);
			// cartoon
			put("мультфильм", NameTopics.Cartoon);
			put("мультик", NameTopics.Cartoon);
			put("какой\\s.*мультфильм",NameTopics.Cartoon);
			put("подскажи\\s.*мультфильм", NameTopics.Cartoon);
			put("посоветуй\\s.*мультфильм", NameTopics.Cartoon);
			// film
			put("фильм", NameTopics.Film);
			put("фильмец", NameTopics.Film);
			put("какой\\s.*фильм", NameTopics.Film);
			put("подскажи\\s.*фильм", NameTopics.Film);
			put("посоветуй\\s.*фильм", NameTopics.Film);
			// series
			put("сериал", NameTopics.Series);
			put("сериальчик", NameTopics.Series);
			put("какой\\s.*сериал", NameTopics.Series);
			put("подскажи\\s.*сериал", NameTopics.Series);
			put("посоветуй\\s.*сериал", NameTopics.Series);
			// towns
			put("города", NameTopics.TownsGame);
			// numbers
			put("поиграем\\s.*числа", NameTopics.PlayNumbers);
			put("сыграем\\s.*числа", NameTopics.PlayNumbers);
			put("отгадывать", NameTopics.PlayNumbers);
			put("загадывать", NameTopics.PlayNumbers);
			//translate service
			put("переведи", NameTopics.TranslateService);
			put("можешь\\s.*перевести", NameTopics.TranslateService);
			put("переводчик", NameTopics.TranslateService);
		}
	};
}
