package com.rohit.dsa;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String parenthesis = "(){}";

        boolean isValidParenthesis = getValidParenthesis(parenthesis);
        System.out.println("Valid parenthesis -> " + isValidParenthesis);
    }

    public static boolean getValidParenthesis(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() && (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']')) {
                return false;
            }
            else {
                if (!stack.empty()) {
                    if ((stack.peek() == '{' && s.charAt(i) == '}') ||
                            stack.peek() == '(' && s.charAt(i) == ')' ||
                            stack.peek() == '[' && s.charAt(i) == ']'
                    ) {
                        stack.pop();
                    }
                    else {
                        stack.push(s.charAt(i));
                    }
                }
                else
                    stack.push(s.charAt(i));
            }
        }

        return stack.empty();
    }
}
