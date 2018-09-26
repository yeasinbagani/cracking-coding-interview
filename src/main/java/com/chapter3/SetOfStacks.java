package com.chapter3;

public class SetOfStacks {

	private static final int LIMIT = 10;
	Stack2 top;

	public boolean isEmpty() {
		return top == null;
	}

	public void push(Stack2 newStack) {

		if (isEmpty()) {
			top = newStack;
		} else {
			newStack.next = top;
			top = newStack;

		}
	}
}
