package com.chapterX;

import java.util.Stack;

public class BalancedBracket {

	public static void main(String[] args) {
		System.out.println(isBalanced("{(([])[])[]]}"));
	}
	static String isBalanced(String s) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(String.valueOf(s.charAt(i)));
			} else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
				if (stack.isEmpty()) {
					return "NO";
				} else if ((stack.peek().equals("(") && s.charAt(i) == ')')
						|| (stack.peek().equals("{") && s.charAt(i) == '}')
						|| (stack.peek().equals("[") && s.charAt(i) == ']')){
					stack.pop();
				} else {
					return "NO";
				}
			}

		}
		if (stack.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
