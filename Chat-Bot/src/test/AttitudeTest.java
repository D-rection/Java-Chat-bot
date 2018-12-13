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
	void testGetStringFriendliness() {
		Attitude a = new Attitude();
		for (int i = 0; i < 2; i++) {
			boolean res = a.getFriendliness().isNeutral();
			assertTrue(res);
			a.decreaseFriendliness();
		}
		for (int i = 3; i > 0; i--) {
			boolean res = a.getFriendliness().isAngry();
			assertTrue(res);
			a.decreaseFriendliness();
		}
	}

}
