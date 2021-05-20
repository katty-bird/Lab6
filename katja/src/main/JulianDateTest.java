package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JulianDateTest {

	@Test
	void test() {
		JulianDate date = new JulianDate(1582, 10, 15);
		assertEquals(date.julianDayNumber, 2299160.5);
	}
	
	@Test
	void test2() {
		JulianDate date1 = new JulianDate(1582, 10, 15);
		JulianDate date2 = new JulianDate(1582, 10, 20);
		assertEquals(5, date1.daysBetween(date2));
	}
}
