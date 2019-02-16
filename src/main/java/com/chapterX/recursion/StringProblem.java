package com.chapterX.recursion;

public class StringProblem {

	public static void reversePrint(String str, int index) {
		if (index < str.length() - 1) {
			reversePrint(str, index + 1);
		}

		System.out.println(str.charAt(index));

	}

	public static void reverseString(char[] s) {

		int mid = s.length / 2;
		for (int i = 0; i < mid; i++) {
			char temp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = temp;
		}

	}

	public static void main(String[] args) {
		char[] a = { 'h', 'e', 'l', 'n', 'o' };
		printArray(a);
		reverseString(a);
		printArray(a);
	}

	static void printArray(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n-------------------");
	}
}
