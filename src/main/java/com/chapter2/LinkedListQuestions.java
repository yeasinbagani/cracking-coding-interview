package com.chapter2;

public class LinkedListQuestions {

	/**
	 * 2.1 Remove duplicate node from list
	 * 
	 * @param list
	 * @return
	 */
	public static DoubleLinkedList removeDuplicate(DoubleLinkedList list) {

		Node node = list.head;
		while (node != null) {
			Node nextNode = node.next;

			while (nextNode != null) {
				if (node.data == nextNode.data) {
					Node nextToNext = nextNode.next;
					Node previousToNext = nextNode.previous;
					if (nextToNext != null) {
						nextToNext.previous = previousToNext;
					}
					if (previousToNext != null) {
						previousToNext.next = nextToNext;
					}
				}

				nextNode = nextNode.next;
			}

			node = node.next;
		}

		return list;
	}

	public static void main(String[] args) {

		DoubleLinkedList list = new DoubleLinkedList();

		list.insertFirst(10);
		list.insertFirst(6);
		list.insertFirst(10);
		list.insertFirst(5);
		list.insertFirst(1);
		list.insertFirst(9);
		list.insertFirst(5);
		list.insertFirst(10);
		
		list.printList();

		DoubleLinkedList list2 = removeDuplicate(list);
		list2.printList();
	}

}
