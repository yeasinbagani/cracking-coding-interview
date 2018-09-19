package com.chapter2;

public class LinkedListQuestions {

	/**
	 * 2.1 Remove duplicate node from double linked list
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

	/**
	 * 2.1 Remove duplicate node from single linked list
	 * 
	 * @param list
	 * @return
	 */
	public static LinkedList removeDuplicate(LinkedList list) {

		Node node = list.head;
		while (node != null) {
			Node nextNode = node.next;
			Node previous = null;

			while (nextNode != null) {
				if (node.data == nextNode.data) {
					previous.next = nextNode.next;
				} else {
					previous = nextNode;
				}

				nextNode = nextNode.next;
			}

			node = node.next;
		}

		return list;
	}

	/**
	 * Get k th node in a list from the last
	 * 
	 */
	public static Node getKthNodeFromLast(LinkedList list, int k) {
		Node currentNode = list.head;
		Node kthNodeFromLast = null;
		int size = 0;

		while (currentNode != null) {
			size++;
			currentNode = currentNode.next;
			if (size == k) {
				kthNodeFromLast = list.head;
			}

			if (size > k) {
				kthNodeFromLast = kthNodeFromLast.next;
			}
		}

		return kthNodeFromLast;

	}

	/**
	 * Delete k th node in a list from the last
	 * 
	 */
	public static LinkedList deleteKthNodeFromLast(LinkedList list, int k) {
		Node currentNode = list.head;
		Node kthNodeFromLast = null;
		Node previousToKthNode = null;
		int size = 0;

		while (currentNode != null) {
			size++;

			currentNode = currentNode.next;
			if (size == k) {
				kthNodeFromLast = list.head;
			}

			if (size > k) {
				if (size == k + 1) {
					previousToKthNode = list.head;
				} else {
					previousToKthNode = previousToKthNode.next;
				}
				kthNodeFromLast = kthNodeFromLast.next;

			}
		}

		if (kthNodeFromLast == null) {
			return list;
		}

		if (previousToKthNode == null) {
			list.head = kthNodeFromLast.next;
			return list;
		}

		previousToKthNode.next = kthNodeFromLast.next;

		return list;

	}

	/**
	 * 2.4 partition
	 * 
	 */
	public static LinkedList partitionList(LinkedList list, int key) {
		Node currentNode = list.head;
		Node previousNode = null;
		while (currentNode != null) {
			if (currentNode.data < key) {
				if (previousNode != null) {
					previousNode.next = currentNode.next;
					list.insert(currentNode.data);
				}
			} else {
				previousNode = currentNode;
			}

			currentNode = currentNode.next;
		}
		return list;
	}

	/**
	 * 2.5 Calculate sum of two linked list and return value in form of a linkedlist
	 * 
	 * @return
	 */
	public static LinkedList sumLists(LinkedList list1, LinkedList list2) {
		int sum = getIntValue(list1) + getIntValue(list2);
		String str = String.valueOf(sum);
		LinkedList list = new LinkedList();

		for (int i = 0; i < str.length(); i++) {
			list.insert(Integer.parseInt(Character.toString(str.charAt(i))));
		}
		return list;
	}

	private static int getIntValue(LinkedList list) {
		Node currentNode = list.head;
		int value = 0;
		int weight = 1;
		while (currentNode != null) {
			value = value + (weight * currentNode.data);
			weight = weight * 10;
			currentNode = currentNode.next;
		}

		return value;
	}

	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();
		list1.insert(1);
		list1.insert(2);
		list1.insert(3);
		list1.insert(4);
		list1.printList();

		LinkedList list2 = new LinkedList();
		list2.insert(4);
		list2.insert(3);
		list2.insert(3);
		list2.insert(2);
		list2.printList();

		sumLists(list1, list2).printList();
	}

}
