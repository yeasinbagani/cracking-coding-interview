package com.chapterX.dymanicProgramming;

public class CoinChange {

	public static int getNumberOfWays(int num, int[] denom, int count) {
		for (int d : denom) {
			if (num == d) {
				count++;
			} else if (num > d) {
				count =  getNumberOfWays(num - d, denom, count);
			}
		}

		return count;
	}

	public static void main(String[] args) {

		int[] a = { 8, 3, 2 };
		System.out.println(getNumberOfWays(5, a, 0));
	}

}
