package edu.westga.exceptionslecture.model;

public class CharCounter {

	public CharCounter() {

	}

	/**
	 * Counts all the characters in the given strings.
	 *
	 * @precondition str1 != null && str2 != null && str3 != null
	 * @postcondition
	 *
	 * @param str1 a string
	 * @param str2 another string
	 * @param str3 yet-another string
	 * @return the total number of characters in all strings
	 */
	public int countAllChars(String str1, String str2, String str3) {
		if (str1 == null) {
			throw new NullPointerException("str1 is null.");
		}
		if (str2 == null) {
			throw new NullPointerException("str2 is null.");
		}
		if (str3 == null) {
			throw new NullPointerException("str3 is null.");
		}
		int count1 = str1.length();
		int count2 = str2.length();
		int count3 = str3.length();
		return count1 + count2 + count3;
	}
}
