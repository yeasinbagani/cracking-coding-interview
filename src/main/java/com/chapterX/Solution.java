package com.chapterX;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}

	public static class MyQueue<Integer> {

		private Stack lifo;
		private Stack fifo;

		public MyQueue() {
			lifo = new Stack();
			fifo = new Stack();
		}

		public void enqueue(int data) {
			lifo.push(data);
		}

		public void dequeue() {
			if (fifo.peek() == null) {
				transferStack(lifo, fifo);
			}
			fifo.pop();
		}

		public int peek() {
			if (fifo.peek() == null) {
				transferStack(lifo, fifo);
			}
			return fifo.peek();
		}

		private void transferStack(Stack from, Stack to) {
			while (from.top != null) {
				to.push(from.pop());
			}
		}
	}

	public static class Stack {

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

		public Integer pop() {
			if (top == null) {
				return null;
			}
			Node temp = top;
			top = top.previous;
			return temp.data;
		}

		public Integer peek() {
			if (top == null) {
				return null;
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
}
