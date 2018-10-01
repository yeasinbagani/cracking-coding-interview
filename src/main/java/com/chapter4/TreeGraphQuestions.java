package com.chapter4;

import com.ds.tree.BinarySearchTree;

public class TreeGraphQuestions {

	/**
	 * 4.2 Given a sorted array, create a binary search tree with minimal height
	 */

	public static BinarySearchTree minimalTree(BinarySearchTree bst, int[] sortedNums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		bst.insert(sortedNums[mid], String.valueOf(sortedNums[mid]));
		minimalTree(bst, sortedNums, start, mid - 1);
		minimalTree(bst, sortedNums, mid + 1, end);
		return bst;
	}

	/**
	 * 4.3 Depth of nodes of a binary search tree
	 * 
	 */
	
	
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		BinarySearchTree bst = minimalTree(new BinarySearchTree(), a, 0, a.length - 1);
		bst.inOrderTravel(bst.root);
		bst.nodeDepth(bst.root);
	}

}
