package datediff.model;

import org.junit.Test;

import java.util.List;

import static datediff.model.MonthsUnit.*;
import static org.junit.Assert.assertEquals;

public class MonthsUnitTest {

	@Test
	public void whenYearIsLeap_DaysInFeb_is_29Days() {
		Integer expected = 29;
		assertEquals(expected, FEBRUARY.lengthOfMonthByYear(2020));
	}

	@Test
	public void whenYearIsNotLeap_DaysInFeb_is_28Days() {
		Integer expected = 28;
		assertEquals(expected, FEBRUARY.lengthOfMonthByYear(2003));
	}

	@Test
	public void whenMonthHas31Days() {
		Integer expected = 31;
		List.of(JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER).forEach(m -> assertEquals(expected, m.lengthOfMonthByYear(2003)));

	}

	@Test
	public void whenMonthHas30Days() {
		Integer expected = 30;
		List.of(APRIL, JUNE, SEPTEMBER, NOVEMBER).forEach(m -> assertEquals(expected, m.lengthOfMonthByYear(2003)));

	}

}
