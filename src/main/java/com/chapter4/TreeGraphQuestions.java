package com.chapter4;

import java.util.ArrayList;
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
	 * 4.5 Given a binary tree check if it is a binary search tree *
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

	/**
	 * 4.8 Given two nodes of a binary tree, find the first common ancestor
	 * 
	 */

	public static Node getCommonAncestor(Node root, int key1, int key2) {
		List<Node> list1 = getAllAncestors(root, key1);
		List<Node> list2 = getAllAncestors(root, key2);

		if (list1 == null || list2 == null) {
			return null;
		}
		int i = list1.size() - 1;
		int j = list2.size() - 1;
		Node result = null;

		while (i >= 0 && j >= 0) {
			if (list1.get(i).key == list2.get(j).key) {
				result = list1.get(i);
				i--;
				j--;
			} else {
				break;
			}
		}

		return result;
	}

	public static List<Node> getAllAncestors(Node node, int key) {

		if (node == null) {
			return null;
		}

		List<Node> list = null;
		List<Node> rightList = getAllAncestors(node.rightChild, key);
		List<Node> leftList = getAllAncestors(node.leftChild, key);

		if (rightList != null) {
			list = rightList;
		} else if (leftList != null) {
			list = leftList;
		}

		if (list != null) {
			list.add(node);
			return list;
		}
		if ((node.rightChild != null && node.rightChild.key == key)
				|| (node.leftChild != null && node.leftChild.key == key)) {
			list = new ArrayList<>();

			list.add(node);
		}

		return list;

	}

	/**
	 * Given a binary search tree node, return the next node in-order
	 * 
	 */
	public static Node getNextNode(Node root, Node parent, Node result, int key) {
		if (root == null) {
			return null;
		}

		if (result != null) {
			return result;
		}
		Node leftResult = getNextNode(root.leftChild, root, result, key);
		Node rightResult = getNextNode(root.rightChild, root, result, key);

		if (leftResult != null) {
			result = leftResult;
		} else if (rightResult != null) {
			result = rightResult;
		}

		if (key == root.key) {
			if (root.rightChild != null) {
				result = getMin(root.rightChild);
			} else {
				result = parent;
			}
		}

		return result;
	}

	public static Node getMin(Node node) {
		if (node == null) {
			return null;
		}

		while (node.leftChild != null) {
			node = node.leftChild;
		}
		return node;
	}

	/**
	 * 4.10 Check if T1 is a subtree of T1, both T1 and T2 are large trees, T1 is
	 * significantly larger than T2
	 * 
	 */

	public static boolean isSubTree(Node node1, Node node2, Node originalNode) {

		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null ^ node2 == null) {
			return false;
		}

		
		boolean result = false; 

		if (node1.key == node2.key) {
			result = isSubTree(node1.leftChild, node2.leftChild, originalNode) && isSubTree(node1.rightChild, node2.rightChild, originalNode);

		} else {
			result = isSubTree(node1.leftChild, originalNode, originalNode) || isSubTree(node1.rightChild, originalNode, originalNode);
		}

		System.out.println(String.format("%s is compared to %s and result is [%s]", node1, node2, result));
		return result;
	}

	public static void main(String[] args) {

		Node node1 = new Node(1, "1");
		Node node2 = new Node(2, "2");
		Node node3 = new Node(3, "3");
		Node node4 = new Node(4, "4");
		Node node5 = new Node(5, "5");
		Node node6 = new Node(6, "6");
		Node node7 = new Node(7, "7");
		Node node8 = new Node(8, "8");
		Node node9 = new Node(9, "9");
		Node node10 = new Node(10, "10");
		Node node11 = new Node(11, "11");
		Node node12 = new Node(12, "12");
		Node node13 = new Node(13, "13");
		Node node14 = new Node(14, "14");
		Node node15 = new Node(15, "15");

		node1.leftChild = node2;
		node1.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node3.leftChild = node6;
		node3.rightChild = node7;

		node4.leftChild = node8;
		node4.rightChild = node9;
		
		node6.leftChild = node10;
		node6.rightChild = node11;
		
		node9.leftChild = node12;
		node9.rightChild = node13;
		
		node11.leftChild = node14;
		node11.rightChild = node15;
		
		Node xnode1 = new Node(1, "1");
		Node xnode2 = new Node(2, "2");
		Node xnode3 = new Node(3, "3");
		Node xnode4 = new Node(4, "4");
		Node xnode5 = new Node(5, "5");
		Node xnode6 = new Node(6, "6");
		Node xnode7 = new Node(7, "7");
		Node xnode8 = new Node(8, "8");
		Node xnode9 = new Node(9, "9");
		Node xnode10 = new Node(10, "10");
		Node xnode11 = new Node(11, "11");
		Node xnode12 = new Node(12, "12");
		Node xnode13 = new Node(13, "13");
		Node xnode14 = new Node(14, "14");
		Node xnode15 = new Node(15, "15");

		/*node1.leftChild = node2;
		node1.rightChild = node3;

		node2.leftChild = node4;
		node2.rightChild = node5;

		node3.leftChild = node6;
		node3.rightChild = node7;

		node4.leftChild = node8;
		node4.rightChild = node9;*/
		
		xnode6.leftChild = xnode10;
		xnode6.rightChild = xnode11;
		
				
		xnode9.leftChild = xnode12;
		xnode9.rightChild = xnode13;
		
		//xnode10.rightChild = xnode1;
		
		xnode11.leftChild = xnode14;
		xnode11.rightChild = xnode15;
		
		
		
		System.out.println(isSubTree(node1, node1, node1));
	}

}
