package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import answers.DifficultLevel;
import towns.TownsData;

public class TownsDataTest {
	@Test
	void rebootTest() {
		TownsData.reboot();
		assertEquals(true, TownsData.isStart());
		assertEquals(false, TownsData.isEndOfGame());
		TownsData.setMaxCountCities(DifficultLevel.Madness);
		assertEquals(true, TownsData.getMaxCountCities() > 1000);
		TownsData.setMaxCountCities(DifficultLevel.Hard);
		assertEquals(true, TownsData.getMaxCountCities() > 1000);
		TownsData.reboot();
	}
}
