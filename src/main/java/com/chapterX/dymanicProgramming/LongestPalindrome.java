package com.chapterX.dymanicProgramming;

import java.util.Hashtable;

public class LongestPalindrome {

	/**
	 * Find the longest palindrome in a character sequence
	 */

	public static boolean getPalindrome(char[] array, int init, int end, Hashtable<String, Boolean> cache, String[] palindrome) {
		if ((end - init) < 1) {
			return true;
		}

		String key = new String(array, init, end - init + 1);
		if (cache.contains(key)) {
			return cache.get(key);
		}
		boolean flag = false;
		if (array[init] == array[end]) {
			flag = getPalindrome(array, init + 1, end - 1, cache, palindrome);
		} else {
			flag = false;
			getPalindrome(array, init + 1, end, cache, palindrome);
			getPalindrome(array, init, end - 1, cache, palindrome);
		}

		if (flag && key.length() > palindrome[0].length()) {
			palindrome[0] = key;
		}
		cache.put(key, flag);
		return flag;
	}

	public static void main(String[] args) {
		String str = "rczbccadaccbnyryn";
		String[] palindrome = {""};
		Hashtable<String, Boolean> table = new Hashtable<>();
		getPalindrome(str.toCharArray(), 0, str.length() - 1, table, palindrome);
		System.out.println(palindrome[0]);
	}
}
