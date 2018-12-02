package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import numbers.GuessNumber;
import numbers.UnknownNumber;

class GuessNumberTest {

	@Test
	void getAnswerStartGameTest() {
		UnknownNumber unknowNumber = new UnknownNumber();
		unknowNumber.setBotNumber(10);
		assertEquals(new GuessNumber().getAnswer("отгадывать", unknowNumber),
				"Окей.Я загадал число от 0 до 100:) Твоя задача его отгадать))) Не бойся я буду давать подсказки:D Вот первая: Введи число:)");
	}

	@Test
	void getAnswerLowerNumberTest() {
		UnknownNumber unknowNumber = new UnknownNumber();
		unknowNumber.setBotNumber(10);
		assertEquals(new GuessNumber().getAnswer("5", unknowNumber), "Моё число больше.");
	}

	@Test
	void getAnswerGreaterNumberTest() {
		UnknownNumber unknowNumber = new UnknownNumber();
		unknowNumber.setBotNumber(10);
		assertEquals(new GuessNumber().getAnswer("15", unknowNumber), "Моё число меньше.");
	}

	@Test
	void getAnswerFinishGameTest() {
		UnknownNumber unknowNumber = new UnknownNumber();
		unknowNumber.setBotNumber(10);
		assertEquals(new GuessNumber().getAnswer("10", unknowNumber), "Ты угадал!");
	}

}
