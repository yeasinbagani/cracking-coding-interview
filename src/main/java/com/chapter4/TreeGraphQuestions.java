package com.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ds.tree.BinarySearchTree;
import com.ds.tree.Node;

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
	 * 4.3 Given a binary tree create a linked list for all nodes at each depth
	 * 
	 */

	public static Map<Integer, LinkedList<Node>> nodeToList(Node node, Map<Integer, LinkedList<Node>> map, int depth) {

		if (node == null) {
			return map;
		}
		depth++;

		if (map.containsKey(depth)) {
			map.get(depth).add(node);
		} else {
			LinkedList<Node> list = new LinkedList<>();
			list.add(node);
			map.put(depth, list);
		}

		nodeToList(node.leftChild, map, depth);
		nodeToList(node.rightChild, map, depth);
		return map;
	}

	/**
	 * 4.4 Given a binary tree check if the tree is balanced. A balanced tree is
	 * such that given a node the difference between two subsequent sub trees can
	 * not be more than one
	 * 
	 */

	public boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}
		boolean isLeftBalanced = isBalanced(node.leftChild);
		boolean isRightBalanced = isBalanced(node.rightChild);

		if (!isLeftBalanced || !isRightBalanced) {
			return false;
		}

		int leftHeight = getHeight(node.leftChild);
		int rightHeight = getHeight(node.rightChild);

		if (Math.abs(rightHeight - leftHeight) > 1) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * Calculates the height of a node
	 */
	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = getHeight(node.leftChild);
		int rightHeight = getHeight(node.rightChild);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	/**
	 * 
	 * 4.5 Given a binary tree check if it is a binary search tree	 * 
	 */
	public boolean isBST(Node node) {
		if (node == null) {
			return true;
		}

		boolean isLeftBST = isBST(node.leftChild);
		boolean isRightBST = isBST(node.rightChild);
		if (!isLeftBST || !isRightBST) {
			return false;
		}

		if (node.leftChild != null && node.key < node.leftChild.key) {
			return false;
		}

		if (node.rightChild != null && node.key <= node.rightChild.key) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {}

}
