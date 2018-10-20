package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import towns.TownsMemory;

public class TownMemoryTest {
	@Test
	void testMemoryA1() {
		TownsMemory.reboot();
		TownsMemory.useTown("������");
		assertTrue(TownsMemory.containsUsedTowns("������"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryA2() {
		TownsMemory.reboot();
		TownsMemory.useTown("������");
		assertTrue(!TownsMemory.containsUnusedTowns("������"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryA3() {
		TownsMemory.reboot();
		assertTrue(TownsMemory.containsUnusedTowns("����"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryUseTown1() {
		TownsMemory.reboot();
		TownsMemory.useTown("������");
		assertTrue(TownsMemory.containsUsedTowns("������"));
		TownsMemory.useTown("�����");
		assertTrue(TownsMemory.containsUsedTowns("������"));
		assertTrue(TownsMemory.containsUsedTowns("�����"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryUseTown3() {
		TownsMemory.reboot();
		TownsMemory.useTown("������");
		assertFalse(TownsMemory.containsUnusedTowns("������"));
		TownsMemory.useTown("�����");
		assertFalse(TownsMemory.containsUnusedTowns("������"));
		assertFalse(TownsMemory.containsUnusedTowns("�����"));
		TownsMemory.reboot();
	}

	@Test
	void testMemoryReboot() {
		TownsMemory.reboot();
		assertFalse(TownsMemory.containsUsedTowns("������"));
		assertFalse(TownsMemory.containsUsedTowns("�����"));
		assertTrue(TownsMemory.containsUnusedTowns("������"));
		assertTrue(TownsMemory.containsUnusedTowns("�����"));
		TownsMemory.reboot();
	}
}
