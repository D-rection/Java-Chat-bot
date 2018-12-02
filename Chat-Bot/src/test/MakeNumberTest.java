package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import numbers.MakeNumber;
import numbers.UnknownNumber;

class MakeNumberTest {

	@Test
	void getAnswerStartGameTest() {
		UnknownNumber unknowNumber = new UnknownNumber();
		assertEquals(new MakeNumber().getAnswer("загадывать", unknowNumber),
				"Окей.Загадай число от 0 до 100:) Моя задача его отгадать))) Только давай мне подсказки(меньше/больше):D Когда угадаю напиши:'угадал'))) Ты готов?");
	}

	@Test
	void getAnswerFinishGameTest() {
		UnknownNumber unknowNumber = new UnknownNumber();
		assertEquals(new MakeNumber().getAnswer("угадал", unknowNumber), "Урааа!!!Было приятно с тобой поиграть)))");
	}

	@Test
	void getAnswerLowerNumberTest() {
		UnknownNumber unknowNumber = new UnknownNumber();
		MakeNumber game = new MakeNumber();
		game.getAnswer("загадывать", unknowNumber);
		assertEquals(game.getAnswer("да", unknowNumber), "50?");
		assertEquals(game.getAnswer("меньше", unknowNumber), "25?");
	}

	@Test
	void getAnswerGreaterNumberTest() {
		UnknownNumber unknowNumber = new UnknownNumber();
		MakeNumber game = new MakeNumber();
		game.getAnswer("загадывать", unknowNumber);
		assertEquals(game.getAnswer("да", unknowNumber), "50?");
		assertEquals(game.getAnswer("больше", unknowNumber), "75?");
	}

}
