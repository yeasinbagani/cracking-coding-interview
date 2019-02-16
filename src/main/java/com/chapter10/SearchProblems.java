package com.chapter10;

public class SearchProblems {

	/**
	 * 10.3 Search in rotated array
	 */
	public static int circularSearch(int[] array, int start, int end, int num) {
		;
		if (start > end) {
			return -1;
		}
		int index = -1;
		if (array[start] > array[end]) {
			int mid = (start + end) / 2;
			index = Math.max(circularSearch(array, start, mid, num), circularSearch(array, mid + 1, end, num));

		} else {
			index = binarySearch(array, start, end, num);
		}

		return index;
	}

	public static int binarySearch(int[] array, int start, int end, int num) {
		System.out.println(String.format("Start: %s, End: %s", start, end));
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		int result = -1;
		if (num == array[mid]) {
			result = mid;
		} else if (num > array[mid]) {
			result = binarySearch(array, mid + 1, end, num);
		} else {
			result = binarySearch(array, start, mid - 1, num);
		}
		return result;
	}

	public static int sortedSearchNoSize(int[] array, Integer start, Integer end, int num) {
		if (start > end) {
			return -1;
		}

		
		int index = -1;
		if (end < array.length && array[end] == -1) {
			end = (start + end) / 2;
			sortedSearchNoSize(array, start, end, num);
		} else if (num > array[end]) {
			start = end + 1;
			end = end * 2;
			sortedSearchNoSize(array, start, end, num);
		} else {
			index = binarySearch(array, start, end, num);
		}

		return index;
	}

	public static void main(String[] args) {
		// int[] a = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int[] a = { 1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25, 27, -1, -1, -1, -1 };
		System.out.println(sortedSearchNoSize(a, 0, 1, 10));
	}
}
