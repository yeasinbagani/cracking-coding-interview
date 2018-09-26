package com.chapter3;

public class Stack2 {

	Node top;
	Stack2 next;

	public boolean isEmpty() {
		return top == null;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	public int pop() {
		if (isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			Node temp = top;
			top = top.next;
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

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}

	}
}
