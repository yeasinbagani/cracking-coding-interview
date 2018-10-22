package com.sort;

public class QuickSort {

	public static void quickSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}

		int pivotPosition = getPivotPosition(array, start, end);
		quickSort(array, start, pivotPosition - 1);
		quickSort(array, pivotPosition + 1, end);
	}

	public static int getPivotPosition(int[] array, int start, int end) {
		int pivot = array[end];

		int i = start;
		int j = start - 1;

		while (i <= end) {
			if (array[i] <= pivot && j < end) {
				j++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;

			}
			i++;

		}
		return j;
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
		quickSort(a, 0, a.length - 1);
		printArray(a);
	}
}
