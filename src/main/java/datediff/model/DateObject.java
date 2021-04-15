package datediff.model;

/**
 * Class to represent Date
 */
public class DateObject implements Comparable<DateObject> {
	/**
	 * The number of days in a 400 year cycle
	 */
	private static final int DAYS_PER_CYCLE = 146097;

	private Integer day;
	private Integer month;
	private Integer year;

	public DateObject(Integer day, Integer month, Integer year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public DateObject(String day, String month, String year) {
		this.day = Integer.valueOf(day);
		this.month = Integer.valueOf(month);
		this.year = Integer.valueOf(year);
	}

	public Integer getDay() {
		return day;
	}

	public Integer getMonth() {
		return month;
	}

	public Integer getYear() {
		return year;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DateObject that = (DateObject) o;

		if (!day.equals(that.day)) return false;
		if (!month.equals(that.month)) return false;
		return year.equals(that.year);
	}

	@Override
	public int hashCode() {
		int result = day.hashCode();
		result = 31 * result + month.hashCode();
		result = 31 * result + year.hashCode();
		return result;
	}

	@Override
	public int compareTo(DateObject that) {
		if (that == null) {
			throw new IllegalArgumentException("Object to compare cannot be null");
		}
		if (this.equals(that)) {
			return 0;
		}
		int compareYears = this.year.compareTo(that.year);
		if (compareYears != 0) {
			return compareYears;
		}
		int compareMonth = this.month.compareTo(that.month);
		if (compareMonth != 0) {
			return compareMonth;
		}
		int compareDays = this.day.compareTo(that.day);
		if (compareDays != 0) {
			return compareDays;
		}
		return -1;
	}

	/*
	 * Translated to Java, original by Robert G. Tantzen, as published in Collected Algorithms of the ACM (CACM algorithm 199)
	 */
	public long toEpochDay() {
		int year = this.year;
		int mon = this.month;
		int day = this.day;
		if (mon < 3) {                /* Adjust for February. */
			mon += 9;
			--year;
		} else
			mon -= 3;

		return ((DAYS_PER_CYCLE * (year / 100L)) / 4L)    /* Century days */
				+ ((1461L * (year % 100)) / 4L)    /* Year days */
				+ (((153L * mon) + 2L) / 5L)        /* Add adjustment for month */
				+ day;           /* Add day */
	}
}
