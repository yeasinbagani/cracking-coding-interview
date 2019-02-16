package com.ds.stack;

public class Stack {

	public Node top;

	public Stack() {
		top = null;
	}

	public void push(int data) {
		Node node = new Node();
		node.data = data;
		node.previous = top;
		top = node;
	}

	public int pop() {
		if (top == null) {
			return Integer.MIN_VALUE;
		}
		Node temp = top;
		top = top.previous;
		return temp.data;
	}

	public int peek() {
		if (top == null) {
			return Integer.MIN_VALUE;
		}
		return top.data;
	}

	public class Node {
		Node previous;
		Integer data;

		public Node() {
			previous = null;
		}
	}

}
