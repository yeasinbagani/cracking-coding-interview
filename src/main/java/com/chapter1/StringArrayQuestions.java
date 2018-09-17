package com.chapter1;

import java.util.HashSet;
import java.util.Set;

public class StringArrayQuestions {

	/**
	 * 1.1 Implement an algorithm to determine if a string has all unique characters
	 * without using another data structure
	 */

	public static boolean isUnique(String str) {
		if (str.length() > 128) { // There are total 128 ASCII characters
			return false;
		}

		boolean[] charSet = new boolean[128];

		for (int i = 0; i < str.length(); i++) {
			if (charSet[str.charAt(i)]) {
				return false;
			} else {
				charSet[str.charAt(i)] = true;
			}
		}

		return true;
	}

	/**
	 * 1.2 Check if two strings are permutation of each other
	 * 
	 * @param args
	 */

	public static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		int[] charSet1 = new int[128];
		int[] charSet2 = new int[128];

		int length = str1.length();

		for (int i = 0; i < length; i++) {
			charSet1[str1.charAt(i)]++;
			charSet2[str2.charAt(i)]++;
		}

		for (int j = 0; j < 128; j++) {
			if (charSet1[j] != charSet2[j]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 1.6 String compression
	 * 
	 * @param args
	 */

	public static String compressString(String str) {
		char p = str.charAt(0);
		char q;
		int r = 1;
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < str.length(); i++) {

			q = str.charAt(i);
			if (p == q) {
				r++;

				continue;
			}
			sb.append(p);
			if (r > 1) {
				sb.append(r);
			}
			p = q;
			r = 1;

		}
		sb.append(p);
		if (r > 1) {
			sb.append(r);
		}
		return sb.toString();
	}

	/**
	 * 1.8 Zero matrix
	 * 
	 * @return
	 */
	public static int[][] zeroMatrix(int[][] matrix) {
		Set<Integer> columnSet = new HashSet<>();
		Set<Integer> rowSet = new HashSet<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					columnSet.add(j);
				}
			}
		}

		rowSet.forEach(a -> {
			for (int i = 0; i < matrix[a].length; i++) {
				matrix[a][i] = 0;
			}
		});

		columnSet.forEach(a -> {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[i][a] = 0;
			}
		});

		return matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 0, 5 }, { 3, 4, 5, 9, 2 }, { 6, 3, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 2, 3, 4, 5 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("\n");
		}
		System.out.println("+++++++++++++++++");
		int[][] matrix2 = zeroMatrix(matrix);

		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	
	

}
