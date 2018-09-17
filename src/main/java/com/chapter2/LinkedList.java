package com.chapter2;

public class LinkedList {

	Node head;
	int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		}
		newNode.next = head;
		head = newNode;

		size++;
	}

	public void remove() {
		if (isEmpty()) {
			return;
		}

		if (size == 1) {
			head = null;
		} else {
			head = head.next;
			size--;
		}
	}
}
