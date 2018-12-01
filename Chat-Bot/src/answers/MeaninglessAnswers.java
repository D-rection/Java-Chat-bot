package answers;

import java.util.HashSet;
import java.util.Random;
import java.util.regex.Pattern;

import bot.AnswerData;
import bot.InputData;
import bot.TopicConversation;

public class MeaninglessAnswers implements TopicConversation{

	public final String[] COMMON_PHRASES = { "Нет ничего ценнее слов, сказанных к месту и ко времени.",
			"Порой молчание может сказать больше, нежели уйма слов.",
			"Перед тем как писать/говорить всегда лучше подумать.", "Вежливая и грамотная речь говорит о величии души.",
			"Приятно когда текст без орфографических ошибок.", "Многословие есть признак неупорядоченного ума.",
			"Слова могут ранить, но могут и исцелять.", "Записывая слова, мы удваиваем их силу.",
			"Кто ясно мыслит, тот ясно излагает.", "Боюсь Вы что-то не договариваете." };
	
	public final String[] ELUSIVE_ANSWERS = { "Вопрос непростой, прошу тайм-аут на раздумья.",
			"Не уверен, что располагаю такой информацией.", "Может лучше поговорим о чём-то другом?",
			"Простите, но это очень личный вопрос.", "Не уверен, что Вам понравится ответ.",
			"Поверьте, я сам хотел бы это знать.", "Вы действительно хотите это знать?",
			"Уверен, Вы уже догадались сами.", "Зачем Вам такая информация?", "Давайте сохраним интригу?" };
	
	@Override
	public AnswerData getAnswerData(InputData data) {
		Random random = new Random();
		String msg = data.textMessage;
		String say = (msg.trim().endsWith("?"))
				? ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)]
				: COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];
		data.currentAttitude.decreaseFriendliness();
		return new AnswerData(say, false);
	}
	
	@Override
	public HashSet<Pattern> getTriggers() {
		return null;
	}
	
	@Override
	public boolean isThisSuitableTrigger(String message, HashSet<Pattern> triggers)
	{
		return true;
	}

}
