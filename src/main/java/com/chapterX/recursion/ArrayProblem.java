package com.chapterX.recursion;

public class ArrayProblem {

	public static int pivotIndex(int[] nums) {
		if (nums.length < 3) {
			return -1;
		}
		int pivot = -1;
		int leftSum = nums[0];
		int rightSum = nums[nums.length - 1];
		int leftIndex = 0;
		int rightIndex = nums.length - 1;

		while (rightIndex > leftIndex) {
			if (rightIndex - leftIndex == 2 && leftSum == rightSum) {
				pivot = leftIndex + 1;
				break;
			}

			if (leftSum > rightSum) {
				rightIndex--;
				rightSum = rightSum + nums[rightIndex];
			} else {
				leftIndex++;
				leftSum = leftSum + nums[leftIndex];
			}

		}

		return pivot;
	}

	public static void main(String[] args) {
		int[] nums = { -1, -1, -1, -1, -1, 0 };
		System.out.println(pivotIndex(nums));
	}

}
