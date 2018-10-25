package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import numbers.UnknowNumber;

class UnknowNumberTest {

	@Test
	void setBotNumberTest() throws NumberFormatException {
		UnknowNumber number = new UnknowNumber();

		try {
			number.setBotNumber(-1);
			fail("Expected NumberFormatException");
		} catch (NumberFormatException thrown) {
			assertEquals("The number does not match the range", thrown.getMessage());
		}

		try {
			number.setBotNumber(101);
			fail("Expected NumberFormatException");
		} catch (NumberFormatException thrown) {
			assertEquals("The number does not match the range", thrown.getMessage());
		}
	}

	@Test
	void getBotNumberTest() throws NumberFormatException {
		UnknowNumber number = new UnknowNumber();
		try {
			number.setBotNumber(10);
			assertTrue(number.getBotNumber() == 10);
		} catch (NumberFormatException thrown) {
			fail("Not expected NumberFormatException");
		}
	}

	@Test
	void setMinNumberTest() throws NumberFormatException {
		UnknowNumber number = new UnknowNumber();

		try {
			number.setMinNumber(-2);
			fail("Expected NumberFormatException");
		} catch (NumberFormatException thrown) {
			assertEquals("The number does not match the range", thrown.getMessage());
		}

		try {
			number.setMinNumber(102);
			fail("Expected NumberFormatException");
		} catch (NumberFormatException thrown) {
			assertEquals("The number does not match the range", thrown.getMessage());
		}
	}

	@Test
	void getMinNumberTest() throws NumberFormatException {
		UnknowNumber number = new UnknowNumber();
		try {
			number.setMinNumber(20);
			assertTrue(number.getMinNumber() == 20);
		} catch (NumberFormatException thrown) {
			fail("Not expected NumberFormatException");
		}
	}

	@Test
	void setMaxNumberTest() throws NumberFormatException {
		UnknowNumber number = new UnknowNumber();

		try {
			number.setMaxNumber(-3);
			fail("Expected NumberFormatException");
		} catch (NumberFormatException thrown) {
			assertEquals("The number does not match the range", thrown.getMessage());
		}

		try {
			number.setMaxNumber(103);
			fail("Expected NumberFormatException");
		} catch (NumberFormatException thrown) {
			assertEquals("The number does not match the range", thrown.getMessage());
		}
	}

	@Test
	void getMaxNumberTest() throws NumberFormatException {
		UnknowNumber number = new UnknowNumber();
		try {
			number.setMaxNumber(30);
			assertTrue(number.getMaxNumber() == 30);
		} catch (NumberFormatException thrown) {
			fail("Not expected NumberFormatException");
		}
	}

}
