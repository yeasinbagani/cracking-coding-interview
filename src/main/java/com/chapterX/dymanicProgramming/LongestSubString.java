package com.chapterX.dymanicProgramming;

import java.util.Hashtable;

public class LongestSubString {

	public static void getLongestSubString(String strA, String strB) {
		String string1 = null;
		String string2 = null;

		if (strA.length() > strB.length()) {
			string1 = strA;
			string2 = strB;
		} else {
			string2 = strA;
			string1 = strB;
		}
		Hashtable<String, Boolean> memo = new Hashtable<>();
		int index = 0;
		int length = 1;
		String[] seq = { "" };

		while (index < string2.length()) {
			if (checkSubString(string1, string2, index, length, memo, seq)) {
				length++;
			} else {
				length = 1;
				index++;
			}
		}
		System.out.println(seq[0]);

	}

	public static boolean checkSubString(String str1, String str2, int index, int length,
			Hashtable<String, Boolean> memo, String[] seq) {
		if ((index + length) > str2.length()) {
			return false;
		}
		String str = str2.substring(index, index + length);

		if (memo.containsKey(str)) {
			return memo.get(str).booleanValue();
		}

		boolean flag = str1.contains(str);
		if (str.length() > seq[0].length() && flag) {
			seq[0] = str;
		}
		memo.put(str, flag);

		return flag;

	}

	public static void main(String[] args) {
		String s = "abcde";
		String b = "abcde";
		getLongestSubString(s, b);
	}

}
