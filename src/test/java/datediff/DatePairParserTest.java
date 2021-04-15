package datediff;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.LocalDate.of;
import static org.junit.Assert.assertEquals;

public class DatePairParserTest {

	private final DatePairParser datePairParser = new DatePairParser();

	@Test
	public void whenValidPairOfDates_YearApart() {
		String pairOfDates = "01 01 2000, 01 01 2001";
		String result = datePairParser.parsePairOfDates(pairOfDates);
		long jdkDaysDiff = jdkDaysBetween(of(2000, 1, 1), of(2001, 1, 1));
		assertEquals(result, pairOfDates + ", " + jdkDaysDiff);
	}

	@Test
	public void whenValidPairOfDates_32YearsApart() {
		String pairOfDates = "01 01 1969, 01 01 2001";
		String result = datePairParser.parsePairOfDates(pairOfDates);
		long jdkDaysDiff = jdkDaysBetween(of(1969, 1, 1), of(2001, 1, 1));
		assertEquals(result, pairOfDates + ", " + jdkDaysDiff);
	}

	@Test
	public void whenValidPairOfDates_EqualDates() {
		String pairOfDates = "01 01 2001, 01 01 2001";
		String result = datePairParser.parsePairOfDates("01 01 2001, 01 01 2001");
		assertEquals(result, pairOfDates + ", 0");
	}

	private long jdkDaysBetween(LocalDate date1, LocalDate date2) {
		return ChronoUnit.DAYS.between(date1, date2);
	}
}
