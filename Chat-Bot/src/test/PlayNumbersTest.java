package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import bot.Attitude;
import bot.InputData;
import numbers.PlayNumbers;

class PlayNumbersTest {

	@Test
	void getAnswerDataStartGameTest() {
		InputData input = new InputData(new Attitude(), "сыграем в числа");
		assertEquals(new PlayNumbers().getAnswerData(input).getAnswer(),
				"Хорошо давай сыграем. Ты хочешь отгадывать или загадывать?");
	}

	@Test
	void getAnswerDataGuessNumberTest() {
		InputData input = new InputData(new Attitude(), "отгадывать");
		assertEquals(new PlayNumbers().getAnswerData(input).getAnswer(),
				"Окей.Я загадал число от 0 до 100:) Твоя задача его отгадать))) Не бойся я буду давать подсказки:D Вот первая: Введи число:)");
	}

	@Test
	void getAnswerDataMakeNumberTest() {
		InputData input = new InputData(new Attitude(), "загадывать");
		assertEquals(new PlayNumbers().getAnswerData(input).getAnswer(),
				"Окей.Загадай число от 0 до 100:) Моя задача его отгадать))) Только давай мне подсказки(меньше/больше):D Когда угадаю напиши:'угадал'))) Ты готов?");
	}

	@Test
	void getAnswerDataNotGameDataTest() {
		InputData input = new InputData(new Attitude(), "пхрпхр");
		assertEquals(new PlayNumbers().getAnswerData(input).getAnswer(), "Это не верный ответ!!!Ты проиграл(");
	}

}
