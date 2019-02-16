package com.app;

public class Application {

	public static void main(String[] args) {

		char[] arr = { 'a', 'b', 'c', 'd', 'e', '1', '2', '3', '4', '5' };
		printArray(arr);

		boolean[] cache = new boolean[arr.length];
		swap(1, arr, cache);
		printArray(arr);
	}

	static int getPosition(int idx, int n) {
		if (idx < n) {
			return 2 * idx;
		} else {
			return 1 + 2 * (idx - n);
		}
	}
	
	
	static void swap(int i, char[] arr, boolean[] cache) {
		
		
		if (cache[i]) {
			int n = 0;
			for (int k = 0; k < cache.length; k++) {
				if (!cache[k]) {
					n = k;
				}
			}
			if (n == 0) {
				return;
			} else {
				i = n;
			}
		} 
		cache[i] = true;
		
		char toReplace = arr[i];
		int toIndex = getPosition(i, arr.length / 2);
		swap(toIndex, arr, cache);

		arr[toIndex] = toReplace;

	}

	static void printArray(char[] arr) {
		System.out.println("-------------------");
		for (char c : arr) {
			System.out.print(c + " ");
		}
		System.out.println("\n");
	}
}