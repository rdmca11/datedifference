package datediff.validator;

import datediff.exceptions.InvalidDateException;
import datediff.model.DateObject;
import datediff.model.MonthsUnit;

import java.util.Optional;

/**
 * Validator class to validate pair of date patterns, and validate values of a {@link DateObject}
 */
public class DateValidator {
	public static final String REGEX = "[\\d]{2}[ ][\\d]{2}[ ][\\d]{4}";
	public static final String DATE_PAIR_REGEX = "^" + REGEX + ", " + REGEX + "$";

	/**
	 * Validates input pair of dates
	 *
	 * @param pairOfDates Expected Format DD MM YYYY, DD MM YYYY
	 * @return true if valid, else false.
	 */
	public static boolean isValidDatePairPattern(String pairOfDates) {
		return pairOfDates.matches(DATE_PAIR_REGEX);
	}

	/**
	 * Validates correctness of days,months and years of the {@link DateObject}
	 *
	 * @param dateObject Date object to validate
	 */
	public static void validateDate(DateObject dateObject) {
		if (dateObject.getYear() < 1900) {
			throw new InvalidDateException("Min Year 1900, Invalid year passed " + dateObject.getYear());
		}
		Optional<MonthsUnit> month = MonthsUnit.of(dateObject.getMonth());
		if (month.isEmpty()) {
			throw new InvalidDateException("Invalid month " + dateObject.getMonth());
		}
		Integer maxDays = month.get().lengthOfMonthByYear(dateObject.getYear());
		if (dateObject.getDay() < 1 || dateObject.getDay() > maxDays) {
			throw new InvalidDateException("Invalid Day " + dateObject.getDay() + ", Max Days in the month " + maxDays);
		}
	}
}
