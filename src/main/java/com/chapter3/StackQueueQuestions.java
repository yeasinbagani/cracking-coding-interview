package com.chapter3;

public class StackQueueQuestions {

	public static void sort(Stack2 stack) {
		Stack2 tempStack = new Stack2();
		tempStack.push(stack.pop());
		int popCount = 0;

		while (!stack.isEmpty()) {
			int data = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > data) {
				stack.push(tempStack.pop());
				popCount++;
			}
			tempStack.push(data);

			while (popCount > 0) {
				tempStack.push(stack.pop());
				popCount--;
			}
		}
		
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	public static void main(String[] args) {
		Stack2 stack = new Stack2();

		stack.push(6);
		stack.push(3);
		stack.push(1);
		stack.push(10);
		stack.push(8);
		stack.push(5);
		stack.push(9);
		stack.push(11);
		sort(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
