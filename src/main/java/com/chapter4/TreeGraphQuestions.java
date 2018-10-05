package com.chapter4;

import java.util.HashMap;
import java.util.LinkedList;
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

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		BinarySearchTree bst = minimalTree(new BinarySearchTree(), a, 0, a.length - 1);
		bst.preOrderTravel(bst.root);
		Map<Integer, LinkedList<Node>> map = nodeToList(bst.root, new HashMap<>(), 0);

		for (Integer i : map.keySet()) {
			System.out.println("Depth: " + i);
			map.get(i).forEach(System.out::println);
			System.out.println("__________________________________");
		}

	}

}
