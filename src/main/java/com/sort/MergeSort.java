package com.sort;

/**
 * Runtime O(nlogn), down side copies entire array
 * 
 * Merge sort recursively splits an array in half, and then the arrays are
 * sorted i.e.when the array size is 1, then merges those arrays in s sorted
 * manner in a third array.
 * 
 * @author moham
 *
 */
public class MergeSort {

	public static int[] mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);

		return arr;
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (end <= start) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, mid, end);

	}

	private static void merge(int[] array, int start, int mid, int end) {
		int[] sorted = new int[end - start + 1];

		int leftIndex = start;
		int rightIndex = mid + 1;
		int index = 0;

		// merge left array and right array in a third array in a sorted manner
		while (leftIndex <= mid && rightIndex <= end) {
			if (array[leftIndex] > array[rightIndex]) {
				sorted[index] = array[rightIndex];
				rightIndex++;
			} else {
				sorted[index] = array[leftIndex];
				leftIndex++;
			}
			index++;
		}

		// if there is any left over form left array
		while (leftIndex <= mid) {
			sorted[index] = array[leftIndex];
			leftIndex++;
			index++;
		}

		// if there is any left over from right array
		while (rightIndex <= end) {
			sorted[index] = array[rightIndex];
			rightIndex++;
			index++;
		}

		// finally replace the unsorted elements from temp sorted array
		for (int i = 0; i <= (end - start); i++) {
			array[start + i] = sorted[i];
		}

	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println("\n--");
	}

	public static void main(String[] args) {
		int[] a = { 5, 9, 6, 2, 6, 11, 13, 1, 2, 4, 17, 10, 8, 7 };
		printArray(a);
		int[] b = mergeSort(a);
		printArray(b);

	}

}
