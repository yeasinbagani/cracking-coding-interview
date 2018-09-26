package com.chapter3;

public class Stack<T> {

	Node<T> top;

	public boolean isEmpty() {
		return top == null;
	}

	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;

		}
	}

	public T pop() {
		if (isEmpty()) {
			return null;
		} else {
			Node<T> temp = top;
			top = top.next;
			return temp.data;
		}
	}

	public void printStack() {
		Node<T> currentNode = this.top;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	private static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			next = null;
		}

		public String toString() {
			return String.valueOf(data);
		}

	}
}
