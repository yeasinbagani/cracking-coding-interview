package com.ds.tree;

public class BinarySearchTree {

	public Node root;

	public void insert(int key, String data) {
		Node node = new Node(key, data);
		if (root == null) {
			root = node;
			return;
		}
		Node currentNode = root;
		Node parent = null;
		boolean isLestChild = false;
		while (currentNode != null) {
			parent = currentNode;
			if (key > currentNode.key) {
				currentNode = currentNode.rightChild;
				isLestChild = false;
			} else {
				currentNode = currentNode.leftChild;
				isLestChild = true;
			}
		}

		if (isLestChild) {
			parent.leftChild = node;
		} else {
			parent.rightChild = node;
		}

	}

	public boolean remove(int key) {
		if (root == null) {
			return false;
		}

		Node currentNode = root;
		Node nodeToBeRemoved = null;
		Node parentNode = null;
		boolean isLeftChild = false;

		while (currentNode != null) {
			if (key == currentNode.key) {
				nodeToBeRemoved = currentNode;
				break;
			} else if (key > currentNode.key) {
				isLeftChild = false;
				parentNode = currentNode;
				currentNode = currentNode.rightChild;
			} else {
				isLeftChild = true;
				parentNode = currentNode;
				currentNode = currentNode.leftChild;
			}

		}

		if (nodeToBeRemoved == null) {
			return false;
		}

		if (root.key == nodeToBeRemoved.key) {
			root = nodeToBeRemoved;
		}
		// If leaf node

		if (nodeToBeRemoved.leftChild == null && nodeToBeRemoved.rightChild == null) {
			if (nodeToBeRemoved == root) {

			} else if (isLeftChild) {
				parentNode.leftChild = null;
			} else {
				parentNode.rightChild = null;
			}
		}

		// If only has right child
		else if (nodeToBeRemoved.leftChild == null) {
			if (isLeftChild) {
				parentNode.leftChild = nodeToBeRemoved.rightChild;
			} else {
				parentNode.rightChild = nodeToBeRemoved.rightChild;
			}
		}
		// If only has left child
		else if (nodeToBeRemoved.rightChild == null) {
			if (isLeftChild) {
				parentNode.leftChild = nodeToBeRemoved.leftChild;
			} else {
				parentNode.rightChild = nodeToBeRemoved.leftChild;
			}
		}

		// If has both child
		else {
			Node smallestNode = nodeToBeRemoved;
			Node parentToSmall = null;
			while (smallestNode.leftChild != null) {
				parentToSmall = nodeToBeRemoved;
				smallestNode = smallestNode.leftChild;
			}

			parentToSmall.leftChild = null;
			if (isLeftChild) {
				parentNode.leftChild = smallestNode;
			} else {
				parentNode.rightChild = smallestNode;
			}
		}
		return true;
	}

	public Node getMin(Node node) {
		if (node == null) {
			return null;
		}

		while (node.leftChild != null) {
			node = node.leftChild;
		}
		return node;
	}

	public void inOrderTravel(Node node) {
		if (node == null) {
			return;
		}

		inOrderTravel(node.leftChild);
		visit(node);
		inOrderTravel(node.rightChild);

	}

	public void preOrderTravel(Node node) {
		if (node == null) {
			return;
		}

		visit(node);
		preOrderTravel(node.leftChild);
		preOrderTravel(node.rightChild);

	}

	public void postOrderTravel(Node node) {
		if (node == null) {
			return;
		}

		postOrderTravel(node.leftChild);
		postOrderTravel(node.rightChild);
		visit(node);

	}

	private void visit(Node node) {
		System.out.println(String.format("#%s: %s", node.key, node.data));
	}

	public int nodeDepth(Node node) {
		if (node == null) {
			return 0;
		}

		int lDepth = nodeDepth(node.leftChild);
		int rDepth = nodeDepth(node.rightChild);
		int depth = Math.max(lDepth, rDepth) + 1;
		System.out.println(String.format("Node: #%s, depth: %s", node.key, depth));

		return depth;

	}
	
}
