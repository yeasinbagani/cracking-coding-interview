package com.chapterX.dymanicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Not solved
 * @author moham
 *
 */
public class CoinChange {

	public static int getNumberOfWays(int num, int[] denom, int count) {
		for (int d : denom) {
			if (num == d) {
				System.out.println(d);
				count++;
			} else if (num > d) {
				count = getNumberOfWays(num - d, denom, count);
			}

		}

		return count;
	}

	public static Map<String, Boolean> getNumberOfWaysXX(int num, int[] denom, String seq, Map<String, Boolean> map) {

		for (int d : denom) {
			if (num == d) {
				map.put(seq + " " + d, true);

			} else if (num > d) {
				seq = seq + " " + d;
				getNumberOfWaysXX(num - d, denom, seq, map);
			} else {
				System.out.println("*** ");
			}
			System.out.println(">>> " + seq);
		}

		return map;
	}

	public static void main(String[] args) {

		int[] a = { 3, 2, 1 };
		Map<String, Boolean> map = getNumberOfWaysXX(5, a, "", new HashMap<>());

		System.out.println(map);
	}

}
