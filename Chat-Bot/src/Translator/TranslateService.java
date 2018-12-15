package Translator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import answers.PatternBasedConversation;
import bot.AnswerData;
import bot.InputData;
import bot.TopicConversation;

public class TranslateService extends PatternBasedConversation
{
	private String targetLanguage = null;
	private TranslateSteps currentStep = TranslateSteps.Start;
	
	private static final String[] triggers =
		{
			"(?iu:переведи)",
			"(?iu:можешь\\s.*перевести)",
			"(?iu:переводчик)",
		};
	
	private HashMap<String, String> languageMap = new HashMap<String, String>()
	{
		{
			put("английский", "en");
			put("на\\s.*английский", "en");
			put("русский", "ru");
			put("на\\s.*русский", "ru");
		}
	};
	
	private HashMap<String, Boolean> exitPatterns = new HashMap<String, Boolean>()
	{
		{
			put("да", true);
			put("пожалуй", true);
			put("конечно", true);
			put("всё", false);
			put("все", false);
			put("нет", false);
			put("хватит", false);
			put("потом", false);
			put("в другой раз", false);
		}
	};

	public TranslateService() {
		super(triggers);
	}

	@Override
	public AnswerData getAnswerData(InputData data) 
	{
		AnswerData result = null;
		switch(currentStep)
		{
		case Start:
		{			
			result = learnLanguage();
			break;
		}
		case InputTargetLang:
		{
			result = chooseLanguage(data);
			break;
		}
		case InputText:
		{
			result = translate(data);
			break;
		}
		case Exit:
		{
			result = exit(data);
			break;
		}
		}
		return result;
	}
	
	private AnswerData learnLanguage()
	{
		String answer = "На какой язык ты хочешь перевести: на русский или "
				+ "на английский?";
		currentStep = TranslateSteps.InputTargetLang;
		return new AnswerData(answer, true);
	}
	
	private String getLanguage(String str)
	{
		String result = null;
		String message = String.join(" ", str.toLowerCase().split("[ {,|.}?]+"));
		for (String stringKey : languageMap.keySet()) 
		{
			Pattern pattern = Pattern.compile(stringKey);
			if (pattern.matcher(message).find()) 
			{
				result = languageMap.get(stringKey);
				break;
			}
		}
		return result;
	}
	
	private AnswerData chooseLanguage(InputData input)
	{
		String lang = getLanguage(input.textMessage);
		AnswerData result = null;
		if (lang != null)
		{
			currentStep = TranslateSteps.InputText;
			targetLanguage = lang;
			String answer = "Введите слово или фразу для перевода";
			result = new AnswerData(answer, true);
		}
		else
		{
			String answer = "Извините, я вас не понял. На какой язык"
					+ " вы хотите перевести текст?";
			result = new AnswerData(answer, true);
		}
		return result;
	}
	
	private AnswerData translate(InputData input)
	{
		String answer = null;
		try 
		{
			answer = GoogleTranslate.translate(GoogleTranslate.detectLanguage(input.textMessage)
					, targetLanguage, input.textMessage);	
		} catch (IOException e) 
		{
			answer = "Вознкикли неполадки с соединением к серверам Google. Извините"
					+ " что не смог ничем помочь.";
		}
		answer = answer + "\nЖелаете ли перевести что-нибудь ещё?";
		currentStep = TranslateSteps.Exit;
		return new AnswerData(answer, true);
	}
	
	private void reboot()
	{
		targetLanguage = null;
		currentStep = TranslateSteps.Start;
	}
	
	private boolean getMeaningInput(String str)
	{
		boolean result = false;
		String message = String.join(" ", str.toLowerCase().split("[ {,|.}?]+"));
		for (String stringKey : exitPatterns.keySet()) 
		{
			Pattern pattern = Pattern.compile(stringKey);
			if (pattern.matcher(message).find()) 
			{
				result = exitPatterns.get(stringKey);
				break;
			}
		}
		return result;
	}
	
	private AnswerData exit(InputData input)
	{
		AnswerData result;
		boolean continueTalk = getMeaningInput(input.textMessage);
		if (continueTalk)
			result = learnLanguage();
		else
		{
			String answer = "Обращайтесь, если что, всегда рада помочь";
			result = new AnswerData(answer, false);
			reboot();
		}
		return result;
	}
}
