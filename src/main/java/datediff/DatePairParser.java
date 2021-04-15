package datediff;

import datediff.model.DateObject;
import datediff.validator.DateValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parser class for Date pairs.
 */
public class DatePairParser {

	/**
	 * Parses pair of dates and returns formatted output.
	 *
	 * @param pairOfDates Pair of dates to parse.
	 * @return Formatted Days Difference
	 */
	public String parsePairOfDates(String pairOfDates) {
		if (!DateValidator.isValidDatePairPattern(pairOfDates)) {
			throw new IllegalArgumentException("Invalid Date Pair values :" + pairOfDates);
		}

		List<DateObject> dateList = Arrays.stream(pairOfDates.split(","))
				.map(String::trim)
				.map(this::generateDateObject)
				.collect(Collectors.toList());

		dateList.forEach(DateValidator::validateDate);

		Long daysDifference = getDaysBetween(dateList.get(0), dateList.get(1));
		if (daysDifference < 0L) {
			throw new IllegalArgumentException("First Date cannot be after Second Date :" + pairOfDates);
		}
		return String.format("%s, %d", pairOfDates, daysDifference);
	}

	/**
	 * Helper method to get Days difference between secondDate and firstDate
	 *
	 * @param firstDateObject  - First Date Object
	 * @param secondDateObject - Second Date Object
	 * @return Long - Difference in Days
	 */
	public Long getDaysBetween(DateObject firstDateObject, DateObject secondDateObject) {
		return secondDateObject.toEpochDay() - firstDateObject.toEpochDay();
	}

	/**
	 * Generates {@link DateObject}
	 *
	 * @param sourceDate dateObject to parse
	 * @return Parsed DateObject
	 */
	private DateObject generateDateObject(String sourceDate) {
		String[] dateArr = sourceDate.split(" ");
		return new DateObject(dateArr[0], dateArr[1], dateArr[2]);
	}
}
