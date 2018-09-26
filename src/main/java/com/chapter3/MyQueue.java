package com.chapter3;

/**
 * 3.4 Implement a queue using two stacks
 * @author moham
 *
 */
public class MyQueue {
	Stack<String> forwardStack;
	Stack<String> reverseStack;
	
	
	public MyQueue() {
		forwardStack = new Stack<>();
		reverseStack = new Stack<>();
	}
	
	public void insert(String data) {
		forwardStack.push(data);
		
	}
	
	public String remove() {
		if (forwardStack.isEmpty() && reverseStack.isEmpty()) {
			return null;
		}
		
		if (reverseStack.isEmpty()) {
			while (!forwardStack.isEmpty()) {
				reverseStack.push(forwardStack.pop());
			}
		}
		return reverseStack.pop();
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.insert("A");
		queue.insert("B");
		queue.insert("C");
		System.out.println(queue.remove());
		queue.insert("D");
		System.out.println(queue.remove());
		queue.insert("E");
		queue.insert("F");
		queue.insert("G");
		System.out.println(queue.remove());
		queue.insert("H");
		queue.insert("I");
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
}
