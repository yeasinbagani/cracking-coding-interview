package com.chapterX.recursion;

public class LinkedListProblem {

	public static ListNode swapPairs(ListNode head) {
		
		if (head.next == null) {
			return head;
		}

		if (head.next.next != null) {
			swapPairs(head.next.next);
		}
		ListNode temp = head.next;
		head.next = head;
		head = temp;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode result = swapPairs(head);
		
	}

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

}
