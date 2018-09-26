package com.chapter3;

public class SortedStack {
	Stack2 mainStack;
	Stack2 tempStack;

	public SortedStack() {
		mainStack = new Stack2();
		tempStack = new Stack2();
	}

	public boolean isEmpty() {
		return mainStack.isEmpty();
	}
	public void push(int data) {
		if (mainStack.isEmpty()) {
			mainStack.push(data);
		} else {
			while (data > mainStack.peek()) {
				tempStack.push(mainStack.pop());
			}

			mainStack.push(data);
			while (!tempStack.isEmpty()) {
				mainStack.push(tempStack.pop());
			}
		}
	}
	
	public int pop() {
		return mainStack.pop();
	}

	public static void main(String[] args) {
		SortedStack stack = new SortedStack();

		stack.push(6);
		stack.push(3);
		stack.push(1);
		stack.push(7);
		stack.push(8);
		stack.push(5);
		stack.push(9);
		stack.push(2);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
