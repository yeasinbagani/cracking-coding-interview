package com.chapter3;

public class AnimalQueue {

	Node head;
	Node tail;

	public AnimalQueue() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void insertFirst(String data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
	}

	public void insertLast(String data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void printList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + "  ");
			currentNode = currentNode.next;
		}
		System.out.println("\n--------------------------------");
	}

	public String getCat() {
		return getAnimal("Cat");
	}

	public String getDog() {
		return getAnimal("Dog");
	}
	private String getAnimal( String animal) {
		Node temp = tail;
		while (!temp.data.startsWith(animal)) {
			temp = temp.previous;
		}
		if (temp.previous != null) {
			temp.previous.next = temp.next;
		}

		if (temp.next != null) {
			temp.next.previous = temp.previous;
		}

		return temp.data;
	}

	public String getAny() {
		if (tail == null) {
			return null;
		} else {
			Node temp = tail;
			tail = tail.previous;
			return temp.data;
		}
	}

	private static class Node {
		Node next;
		Node previous;
		String data;

		public Node(String data) {
			this.data = data;
			next = null;
			previous = null;
		}
	}
	
	public static void main(String[] args) {
		AnimalQueue queue = new AnimalQueue();
		queue.insertFirst("Dog#1");
		queue.insertFirst("Dog#2");
		queue.insertFirst("Cat#1");
		queue.insertFirst("Cat#2");
		queue.insertFirst("Cat#3");
		queue.insertFirst("Dog#3");
		queue.insertFirst("Cat#4");
		queue.insertFirst("Cat#5");
		queue.insertFirst("Dog#4");
		queue.insertFirst("Dog#5");
		queue.insertFirst("Dog#6");
		queue.insertFirst("Cat#6");
		queue.insertFirst("Dog#7");
		/*System.out.println(queue.getAny());
		System.out.println(queue.getAny());
		System.out.println(queue.getAny());
		System.out.println(queue.getDog());*/
		System.out.println(queue.getDog());
		System.out.println(queue.getCat());
		System.out.println(queue.getCat());
		System.out.println(queue.getCat());
		System.out.println(queue.getCat());
		System.out.println(queue.getCat());
		System.out.println(queue.getCat());
		System.out.println(queue.getAny());
		System.out.println(queue.getAny());
		System.out.println(queue.getAny());
		System.out.println(queue.getAny());
		System.out.println(queue.getAny());
		System.out.println(queue.getAny());
		/*System.out.println(queue.getAny());
		System.out.println(queue.getDog());*/
	}

}
