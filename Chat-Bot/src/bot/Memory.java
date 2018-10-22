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
	Map<String, TopicConversation> patternsForAnalysis = new HashMap<String, TopicConversation>() {
		{
			// hello
			put("хай", new Hello());
			put("привет", new Hello());
			put("здорово", new Hello());
			put("здравствуй", new Hello());
			put("здаровки", new Hello());
			// whatcan
			put("что\\s.*можешь",  new WhatCan());
			put("что\\s.*умеешь",  new WhatCan());
			// howareyou
			put("как\\s.*дела", new HowAreYou());
			put("как\\s.*жизнь", new HowAreYou());
			// whatareyoudoing
			put("зачем\\s.*тут", new WhatAreYouDoing());
			put("зачем\\s.*здесь", new WhatAreYouDoing());
			put("что\\s.*делаешь", new WhatAreYouDoing());
			put("чем\\s.*занимаешься", new WhatAreYouDoing());
			put("что\\s.*творишь", new WhatAreYouDoing());
			put("чем\\s.*занят", new WhatAreYouDoing());
			// whatday
			put("какой\\s.*день",  new WhatDay());
			put("какое\\s.*число",  new WhatDay());
			put("какой\\\\s.*день",  new WhatDay());
			put("какой\\\\s.*число",  new WhatDay());
			// whattime
			put("который\\s.*час", new WhatTime());
			put("сколько\\s.*время", new WhatTime());
			// bye
			put("прощай", new Bye());
			put("пока", new Bye());
			put("покеда", new Bye());
			put("увидимся", new Bye());
			put("до\\s.*свидания", new Bye());
			// whatwatch
			put("что\\s.*посмотреть", new WhatWatch());
			put("что\\s.глянуть", new WhatWatch());
			// cartoon
			put("мультфильм", new Cartoon());
			put("мультик", new Cartoon());
			put("какой\\s.*мультфильм", new Cartoon());
			put("подскажи\\s.*мультфильм", new Cartoon());
			put("посоветуй\\s.*мультфильм", new Cartoon());
			// film
			put("фильм", new Film());
			put("фильмец", new Film());
			put("какой\\s.*фильм", new Film());
			put("подскажи\\s.*фильм", new Film());
			put("посоветуй\\s.*фильм", new Film());
			// series
			put("сериал", new Series());
			put("сериальчик", new Series());
			put("какой\\s.*сериал", new Series());
			put("подскажи\\s.*сериал", new Series());
			put("посоветуй\\s.*сериал", new Series());
			// towns
			put("города", new TownsGame());
			// numbers
			put("поиграем\\s.*числа", new PlayNumbers());
			put("сыграем\\s.*числа", new PlayNumbers());
			put("отгадывать",  new PlayNumbers());
			put("загадывать", new PlayNumbers());
		}
	};
}
