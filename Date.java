package DataStructure;
/* Date.java */

public class Date {

	/* Put your private data fields here. */

	/**
	 * Constructs a date with the given month, day and year. If the date is not
	 * valid, the entire program wid halt with an error message.
	 * 
	 * @param month is a month, numbered in the range 1...12.
	 * @param day   is between 1 and the number of days in the given month.
	 * @param year  is the year in question, with no digits omitted.
	 */
	private int month;

	private int day;

	private int year;

	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;

	}

	/**
	 * 
	 * 
	 * Constructs a Date object corresponding to the given string.
	 * 
	 * @param s should be a string of the form "month/day/year" where month must be
	 *          one or two digits, day must be one or two digits, and year must be
	 *          between 1 and 4 digits. If s does not match these requirements or is
	 *          not a valid date, the program halts with an error message.
	 */

	public Date(String s) {
		// System.out.println("date cons "+s);
		String[] date = s.split("/");

		int month = Integer.parseInt(date[0]);
		int day = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);

		if (isValidDate(month, day, year)) {
			this.month = month;
			this.day = day;
			this.year = year;

		}

		else {
			System.out.println(s + "is not valid");
			System.exit(0);
		}

	}

	/**
	 * Checks whether the given year is a leap year.
	 * 
	 * @return true if and only if the input year is a leap year.
	 */
	public static boolean isLeapYear(int year) {

		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
			return true;

		else
			return false; // replace this line with your solution
	}

	/**
	 * Returns the number of days in a given month.
	 * 
	 * @param month is a month, numbered in the range 1...12.
	 * @param year  is the year in question, with no digits omitted.
	 * @return the number of days in the given month.
	 */

	public static int daysInMonth(int month, int year) {
		int days = -1;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			days = 31;
		else if (month == 2) {
			days = 28;
			if (isLeapYear(year))
				days = 29;
		}

		else if (month == 4 || month == 6 || month == 9 || month == 11)
			days = 30;

		return days;
	}

	/**
	 * Checks whether the given date is valid.
	 * 
	 * @return true if and only if month/day/year constitute a valid date.
	 *
	 *         Years prior to A.D. 1 are NOT valid.
	 */
	public static boolean isValidDate(int month, int day, int year) {
		int daysInMonth = daysInMonth(month, year);
		boolean validDate = false;

		if (month < 1 || month > 12) {
			System.out.println("Month is not valid");
			validDate = false;
			System.exit(0);
		} else if (day < 1 || day > daysInMonth) {
			System.out.println("day is not valid");
			validDate = false;
			System.exit(0);
		} else if (year < 1 || year > 10000) {
			System.out.println("year is not valid");
			validDate = false;
			System.exit(0);
		}

		validDate = true;

		return validDate;

	} // end of a function

	/**
	 * Returns a string representation of this date in the form month/day/year. The
	 * month, day, and year are expressed in fud as integers; for example, 12/7/2006
	 * or 3/21/407.
	 * 
	 * @return a String representation of this date.
	 */
	public String toString() {
		// return "stuff"; // replace this line with your solution
		return month + "/" + day + "/" + year;
	}

	/**
	 * Determines whether this Date is before the Date d.
	 * 
	 * @return true if and only if this Date is before d.
	 */
	public boolean isBefore(Date d) {
		boolean before = false;
		if (this.year <= d.year) {

			if ((this.month < d.month) || (this.day < d.day) || (this.year < d.year)) {
				before = true;
			}
		} else
			before = false;

		return before;

	}

	/**
	 * Determines whether this Date is after the Date d.
	 * 
	 * @return true if and only if this Date is after d.
	 */
	public boolean isAfter(Date d) {
		boolean after = false;
		if (this.year >= d.year) {
			if ((this.month > d.month) || (this.day > d.day) || (this.year > d.year)) {
				after = true;
			}
		} else
			after = false;

		return after; // replace this line with your solution

	}

	/**
	 * Returns the number of this Date in the year.
	 * 
	 * @return a number n in the range 1...366, inclusive, such that this Date is
	 *         the nth day of its year. (366 is used only for December 31 in a leap
	 *         year.)
	 */

	public int dayInYear() {
		int days = 0;
		if (isLeapYear(year)) {
			days = 366;
		} else {
			days = 365;
		}
		return days; // replace this line with your solution

	}

	/**
	 * Determines the difference in days between d and this Date. For example, if
	 * this Date is 12/15/2012 and d is 12/14/2012, the difference is 1. If this
	 * Date occurs before d, the result is negative.
	 * 
	 * @return the difference in days between d and this date.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public int difference(Date d) {

		if (d == this) {

			return (d.month - this.month) - (d.day - this.day) - (d.year - this.year);
		}

		else {

			int totalDays = 0;
			int monthDaysOfStartingYear = 0;
			int remainingDaysInStartingYear = 0;

			int daysOfYear = 0;
			int totalDaysInYear = 0;

			int remainingDaysInEndingYear = 0;
			int monthDaysOfEndingYear = 0;

			for (int i = 1; i < d.month; i++) {

				monthDaysOfStartingYear += daysInMonth(i, d.year);
			}
			remainingDaysInStartingYear = d.dayInYear() - (monthDaysOfStartingYear + d.day);

			for (int j = d.year + 1; j < this.year; j++) {

				if (isLeapYear(j)) {
					daysOfYear = 366;
				} else {
					daysOfYear = 365;
				}
				totalDaysInYear += daysOfYear;
			}

			for (int k = 1; k < this.month; k++) {

				monthDaysOfEndingYear += daysInMonth(k, this.year);
			}

			remainingDaysInEndingYear += monthDaysOfEndingYear + this.day;

			totalDays += remainingDaysInStartingYear + totalDaysInYear + remainingDaysInEndingYear;

			return totalDays;
		} // end of else

		// replace this line with your solution
	}

	public static void main(String[] argv) {
		System.out.println("\nTesting constructors.");
		Date d1 = new Date(1, 1, 1);
		System.out.println("Date should be 1/1/1: " + d1);
		d1 = new Date("2/4/2");
		System.out.println("Date should be 2/4/2: " + d1);
		d1 = new Date("2/29/2000");
		System.out.println("Date should be 2/29/2000: " + d1);
		d1 = new Date("2/29/1904");
		System.out.println("Date should be 2/29/1904: " + d1);

		d1 = new Date(12, 31, 1975);
		System.out.println("Date should be 12/31/1975: " + d1);
		Date d2 = new Date("1/1/1976");
		System.out.println("Date should be 1/1/1976: " + d2);
		Date d3 = new Date("1/2/1976");
		System.out.println("Date should be 1/2/1976: " + d3);

		Date d4 = new Date("2/27/1977");
		Date d5 = new Date("8/31/2110");
		
		System.out.println("\nTesting specific year is a leap year or not " );
		
		
		System.out.println("1975 should be false " + isLeapYear(1975));
		System.out.println("1345 should be false " + isLeapYear(1345));
		System.out.println("2020 should be true " +isLeapYear(2020));
		System.out.println("2030 should be false " +isLeapYear(2030));
		System.out.println("2001 should be false " +isLeapYear(2001));
		System.out.println("2008 should be true " +isLeapYear(2008));

		System.out.println("\nTesting before and after.");
		System.out.println(d2 + " after " + d1 + " should be true: " + d2.isAfter(d1));
		System.out.println(d3 + " after " + d2 + " should be true: " + d3.isAfter(d2));
		System.out.println(d1 + " after " + d1 + " should be false: " + d1.isAfter(d1));
		System.out.println(d1 + " after " + d2 + " should be false: " + d1.isAfter(d2));
		System.out.println(d2 + " after " + d3 + " should be false: " + d2.isAfter(d3));

		System.out.println(d1 + " before " + d2 + " should be true: " + d1.isBefore(d2));
		System.out.println(d2 + " before " + d3 + " should be true: " + d2.isBefore(d3));
		System.out.println(d1 + " before " + d1 + " should be false: " + d1.isBefore(d1));
		System.out.println(d2 + " before " + d1 + " should be false: " + d2.isBefore(d1));
		System.out.println(d3 + " before " + d2 + " should be false: " + d3.isBefore(d2));

		System.out.println("\nTesting difference.");
		System.out.println(d1 + " - " + d1 + " should be 0: " + d1.difference(d1));
		System.out.println(d2 + " - " + d1 + " should be 1: " + d2.difference(d1));
		System.out.println(d3 + " - " + d1 + " should be 2: " + d3.difference(d1));
		System.out.println(d4 + " - " + d3 + " should be 422: " + d4.difference(d3));
		System.out.println(d5 + " - " + d4 + " should be 48762: " + d5.difference(d4));

	}

}
