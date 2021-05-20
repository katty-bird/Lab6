package result.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import result.main.JulianDate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

class JulianDateTest {

	private JulianDate julianDate;

	@BeforeEach
	public void setUp() throws Exception {
		julianDate = new JulianDate(1582, 10, 15);
	}

	@Test
	@DisplayName("Test if converting a date to Julian date works correctly")
	void testConvertDateToJulianDate() {
		assertEquals(julianDate, 2299160.5);
	}
	
	@Test
	@DisplayName("Test if the daysBetween method works correctly")
	void testDaysBetweenTwoDate() {
		JulianDate date1 = new JulianDate(1582, 10, 15);
		JulianDate date2 = new JulianDate(1582, 10, 20);
		assertEquals(Optional.of(5), julianDate.daysBetween(date2));
	}

	@Test
	@DisplayName("Test if the tomorrow method works correctly")
	void testTomorrow() {
		//TODO Test erstellen
	}

	@Test
	@DisplayName("Test if the yesterday method works correctly")
	void testYesterday() {

		//TODO Test erstellen

	}
}
