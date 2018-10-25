package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import numbers.MakeNumber;
import numbers.UnknowNumber;

class MakeNumberTest {

	@Test
	void getAnswerStartGameTest() {
		UnknowNumber unknowNumber = new UnknowNumber();
		assertEquals(new MakeNumber().getAnswer("загадывать", unknowNumber),
				"Окей.Загадай число от 0 до 100:) Моя задача его отгадать))) Только давай мне подсказки(меньше/больше):D Когда угадаю напиши:'угадал'))) Ты готов?");
	}

	@Test
	void getAnswerFinishGameTest() {
		UnknowNumber unknowNumber = new UnknowNumber();
		assertEquals(new MakeNumber().getAnswer("угадал", unknowNumber), "Урааа!!!Было приятно с тобой поиграть)))");
	}

	@Test
	void getAnswerLowerNumberTest() {
		UnknowNumber unknowNumber = new UnknowNumber();
		MakeNumber game = new MakeNumber();
		game.getAnswer("загадывать", unknowNumber);
		assertEquals(game.getAnswer("да", unknowNumber), "50?");
		assertEquals(game.getAnswer("меньше", unknowNumber), "25?");
	}

	@Test
	void getAnswerGreaterNumberTest() {
		UnknowNumber unknowNumber = new UnknowNumber();
		MakeNumber game = new MakeNumber();
		game.getAnswer("загадывать", unknowNumber);
		assertEquals(game.getAnswer("да", unknowNumber), "50?");
		assertEquals(game.getAnswer("больше", unknowNumber), "75?");
	}

}
