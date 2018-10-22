package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import towns.TownsMemory;

public class TownMemoryTest {
	private TownsMemory townsMemory = new TownsMemory();
	@Test
	void testMemoryA1() {
		townsMemory.reboot();
		townsMemory.useTown("Абакан");
		assertTrue(townsMemory.containsUsedTowns("Абакан"));
		townsMemory.reboot();
	}

	@Test
	void testMemoryA2() {
		townsMemory.reboot();
		townsMemory.useTown("Абакан");
		assertTrue(!townsMemory.containsUnusedTowns("Абакан"));
		townsMemory.reboot();
	}

	@Test
	void testMemoryA3() {
		townsMemory.reboot();
		assertTrue(townsMemory.containsUnusedTowns("Омск"));
		townsMemory.reboot();
	}

	@Test
	void testMemoryUseTown1() {
		townsMemory.reboot();
		townsMemory.useTown("Абакан");
		assertTrue(townsMemory.containsUsedTowns("Абакан"));
		townsMemory.useTown("Киров");
		assertTrue(townsMemory.containsUsedTowns("Абакан"));
		assertTrue(townsMemory.containsUsedTowns("Киров"));
		townsMemory.reboot();
	}

	@Test
	void testMemoryUseTown3() {
		townsMemory.reboot();
		townsMemory.useTown("Абакан");
		assertFalse(townsMemory.containsUnusedTowns("Абакан"));
		townsMemory.useTown("Киров");
		assertFalse(townsMemory.containsUnusedTowns("Абакан"));
		assertFalse(townsMemory.containsUnusedTowns("Киров"));
		townsMemory.reboot();
	}

	@Test
	void testMemoryReboot() {
		townsMemory.reboot();
		assertFalse(townsMemory.containsUsedTowns("Абакан"));
		assertFalse(townsMemory.containsUsedTowns("Киров"));
		assertTrue(townsMemory.containsUnusedTowns("Абакан"));
		assertTrue(townsMemory.containsUnusedTowns("Киров"));
		townsMemory.reboot();
	}
}
