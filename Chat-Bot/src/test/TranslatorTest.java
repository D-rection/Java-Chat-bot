package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Translator.TranslateService;
import bot.AnswerData;
import bot.Attitude;
import bot.InputData;


class TranslatorTest 
{
	@Test
	void testStartAnswer() 
	{
		TranslateService translator = new TranslateService();
		String answer = "На какой язык ты хочешь перевести: на русский или "
				+ "на английский?";
		assertEquals(answer, translator.getAnswerData(new InputData(new Attitude(), "some text")).getAnswer());
	}
	@Test
	void testLangAnswer() 
	{
		TranslateService translator = new TranslateService();
		String answer = "Извините, я вас не понял. На какой язык"
				+ " вы хотите перевести текст?";
		AnswerData data = translator.getAnswerData(new InputData(new Attitude(), "some text"));
		assertEquals(answer, translator.getAnswerData(new InputData(new Attitude(), "some text")).getAnswer());
		answer = "Введите слово или фразу для перевода";
		assertEquals(answer, translator.getAnswerData(new InputData(new Attitude(), "английский")).getAnswer());
	}
	
	@Test
	void testTranslateAnswer() 
	{
		TranslateService translator = new TranslateService();
		AnswerData data = translator.getAnswerData(new InputData(new Attitude(), "some text"));
		data = translator.getAnswerData(new InputData(new Attitude(), "английский"));
		String answer = "boy" + "\nЖелаете ли перевести что-нибудь ещё?";
		String realAnswer = translator.getAnswerData(new InputData(new Attitude(), "мальчик")).getAnswer();
		assertEquals(answer, realAnswer);
		
		TranslateService translator1 = new TranslateService();
		AnswerData data1 = translator1.getAnswerData(new InputData(new Attitude(), "some text"));
		data1 = translator1.getAnswerData(new InputData(new Attitude(), "английский"));
		String answer1 = "girl" + "\nЖелаете ли перевести что-нибудь ещё?";
		String realAnswer1 = translator1.getAnswerData(new InputData(new Attitude(), "девочка")).getAnswer();
		assertEquals(answer1, realAnswer1);
		
		TranslateService translator2 = new TranslateService();
		AnswerData data2 = translator2.getAnswerData(new InputData(new Attitude(), "some text"));
		data2 = translator2.getAnswerData(new InputData(new Attitude(), "русский"));
		String answer2 = "как" + "\nЖелаете ли перевести что-нибудь ещё?";
		String realAnswer2 = translator2.getAnswerData(new InputData(new Attitude(), "how")).getAnswer();
		assertEquals(answer2, realAnswer2);
	}
	
	@Test
	void tesExitAnswer() 
	{
		TranslateService translator = new TranslateService();
		String answer = "Обращайтесь если что, всегда рада помочь";
		AnswerData data = translator.getAnswerData(new InputData(new Attitude(), "some text"));
		data = translator.getAnswerData(new InputData(new Attitude(), "английский"));
		data = translator.getAnswerData(new InputData(new Attitude(), "английский"));
		assertEquals(answer, translator.getAnswerData(new InputData(new Attitude(), "Нет")).getAnswer());
		
		TranslateService translator1 = new TranslateService();
		String answer1 = "На какой язык ты хочешь перевести: на русский или "
				+ "на английский?";
		AnswerData data1 = translator1.getAnswerData(new InputData(new Attitude(), "some text"));
		data = translator1.getAnswerData(new InputData(new Attitude(), "английский"));
		data = translator1.getAnswerData(new InputData(new Attitude(), "английский"));
		assertEquals(answer1, translator.getAnswerData(new InputData(new Attitude(), "Да")).getAnswer());
	}
}
