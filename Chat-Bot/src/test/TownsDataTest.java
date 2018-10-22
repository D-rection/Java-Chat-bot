package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import answers.DifficultLevel;
import towns.TownsData;

public class TownsDataTest {
	@Test
	void rebootTest() {
		TownsData townsData = new TownsData();
		townsData.reboot();
		assertEquals(true, townsData.isStart());
		assertEquals(false, townsData.isEndOfGame());
		townsData.setMaxCountCities(DifficultLevel.Madness);
		assertEquals(true, townsData.getMaxCountCities() > 1000);
		townsData.setMaxCountCities(DifficultLevel.Hard);
		assertEquals(true, townsData.getMaxCountCities() > 1000);
		townsData.reboot();
	}
}
