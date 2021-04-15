package datediff.model;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enum to represent possible Months in a year and there relative position.
 */
public enum MonthsUnit {
	JANUARY(1),
	FEBRUARY(2),
	MARCH(3),
	APRIL(4),
	MAY(5),
	JUNE(6),
	JULY(7),
	AUGUST(8),
	SEPTEMBER(9),
	OCTOBER(10),
	NOVEMBER(11),
	DECEMBER(12);

	private final Integer monthNumber;

	MonthsUnit(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	/**
	 * Returns Months Enum representation for a given month number.
	 *
	 * @param monthNumber to parse.
	 * @return Optional of {@link MonthsUnit}
	 */
	public static Optional<MonthsUnit> of(Integer monthNumber) {
		return Arrays.stream(MonthsUnit.values())
				.filter(p -> p.monthNumber.equals(monthNumber))
				.findFirst();
	}

	/**
	 * Returns max days in a month for a year
	 *
	 * @param year Year for which to determine Days in Months, needed for leap year calculations.
	 * @return Days in month for the year
	 */
	public Integer lengthOfMonthByYear(Integer year) {
		boolean isLeapYear = (year % 100 == 0) ? (year % 400 == 0) : (year % 4 == 0);
		switch (this) {
			case FEBRUARY:
				return isLeapYear ? 29 : 28;
			case APRIL:
			case JUNE:
			case SEPTEMBER:
			case NOVEMBER:
				return 30;
			default:
				return 31;
		}
	}
}
