package com.chapterX;

public class ArrayQuestions {

	/**
	 * Give you an array which has n integers,it has both positive and negative
	 * integers.Now you need sort this array in a special way.After that,the
	 * negative integers should in the front,and the positive integers should in the
	 * back.Also the relative position should not be changed. eg. -1 1 3 -2 2 ans:
	 * -1 -2 1 3 2. o(n)time complexity and o(1) space complexity is perfect.
	 */

	public static int[] reOrder(int[] numArray) {
		int replaceIndex = 0;
		int valueTobeReplaced = Integer.MAX_VALUE;

		for (int i = 0; i < numArray.length; i++) {
			if (numArray[i] < 0) {

				if (i == replaceIndex) {
					replaceIndex++;
				} else {
					valueTobeReplaced = numArray[i];

					for (int j = replaceIndex; j <= i; j++) {
						int temp = numArray[j];
						numArray[j] = valueTobeReplaced;
						valueTobeReplaced = temp;
					}
					replaceIndex++;

				}

			}

		}

		return numArray;

	}

	public static void main(String[] args) {
		int[] a = { -7, 1, 8, -3, 2, -5, 9, -6 };
		printArray(a);

		int[] b = reOrder(a);
		printArray(b);

	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println("\n------------");
	}
}
