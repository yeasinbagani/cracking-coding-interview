package com.chapter3;

public class MinStack {

	Node top;
	int min;
	MinStack next;

	public boolean isEmpty() {
		return top == null;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			top = newNode;
			min = data;
		} else {
			newNode.next = top;
			top = newNode;
			if (min > data) {
				newNode.min = data;
				min = data;
			} else {
				newNode.min = min;
			}

		}
	}

	public int pop() {
		if (isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			Node temp = top;
			top = top.next;
			min = top.min;
			return temp.data;
		}
	}

	public int peek() {

		if (isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return top.data;
		}

	}

	public void printStack() {
		Node currentNode = this.top;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public int getMin() {
		return this.min;
	}

	private static class Node {
		int data;
		int min;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}

	}
}
