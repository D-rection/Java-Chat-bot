package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bot.Attitude;
import bot.Mood;

class AttitudeTest {

	@Test
	void testAttitude() {
		Attitude a = new Attitude();
		assertNotNull(a);
	}

	@Test
	void testGetByteFriendliness() {
		Attitude a = new Attitude();
		for (int i = 5; i < 10; i++) {
			assertTrue(a.getByteFriendliness() == i);
			a.increasedFriendliness();
		}
	}

	@Test
	void testGetStringFriendliness() {
		Attitude a = new Attitude();
		for (int i = 5; i > 3; i--) {
			assertTrue(a.getFriendliness() == Mood.Neutral);
			a.decreaseFriendliness();
		}
		for (int i = 3; i > 0; i--) {
			assertTrue(a.getFriendliness() == Mood.Angry);
			a.decreaseFriendliness();
		}
	}

	@Test
	void testIncreasedFriendliness() {
		Attitude a = new Attitude();
		for (int i = 0; i < 6; i++)
			a.increasedFriendliness();
		assertTrue(a.getByteFriendliness() == 9 && a.getFriendliness() == Mood.Cheerful);

	}

	@Test
	void testDecreaseFriendliness() {
		Attitude a = new Attitude();
		for (int i = 0; i < 6; i++)
			a.decreaseFriendliness();
		assertTrue(a.getByteFriendliness() == 1 && a.getFriendliness() == Mood.Angry);

	}

}
