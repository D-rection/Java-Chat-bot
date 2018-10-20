package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import towns.TownsMemory;

public class TownMemoryTest {
	@Test
	void testMemoryA1() {
		TownsMemory.reboot();
		TownsMemory.useTown("Абакан");
		assertTrue(TownsMemory.containsUsedTowns("Абакан"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryA2() {
		TownsMemory.reboot();
		TownsMemory.useTown("Абакан");
		assertTrue(!TownsMemory.containsUnusedTowns("Абакан"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryA3() {
		TownsMemory.reboot();
		assertTrue(TownsMemory.containsUnusedTowns("Омск"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryUseTown1() {
		TownsMemory.reboot();
		TownsMemory.useTown("Абакан");
		assertTrue(TownsMemory.containsUsedTowns("Абакан"));
		TownsMemory.useTown("Киров");
		assertTrue(TownsMemory.containsUsedTowns("Абакан"));
		assertTrue(TownsMemory.containsUsedTowns("Киров"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryUseTown3() {
		TownsMemory.reboot();
		TownsMemory.useTown("Абакан");
		assertFalse(TownsMemory.containsUnusedTowns("Абакан"));
		TownsMemory.useTown("Киров");
		assertFalse(TownsMemory.containsUnusedTowns("Абакан"));
		assertFalse(TownsMemory.containsUnusedTowns("Киров"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryReboot() {
		TownsMemory.reboot();
		assertFalse(TownsMemory.containsUsedTowns("Абакан"));
		assertFalse(TownsMemory.containsUsedTowns("Киров"));
		assertTrue(TownsMemory.containsUnusedTowns("Абакан"));
		assertTrue(TownsMemory.containsUnusedTowns("Киров"));
		TownsMemory.reboot();
	}
}
