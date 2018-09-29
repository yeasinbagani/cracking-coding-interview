package com.chapterX;

public class MathAndLogicQuestions {

	public static void swapIntegers(int a, int b) {
		System.out.println("Before a = " + a + ", b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After a = " + a + ", b = " + b);
	}
	
	public static void main(String[] args) {
		swapIntegers(100, 200);
	}
}
