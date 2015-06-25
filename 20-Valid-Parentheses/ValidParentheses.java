// Valid Parentheses Total Accepted: 56108 Total Submissions: 211423 My Submissions Question Solution 
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

// Hide Tags Stack String

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.equals("") || s.length() == 0) {
        	return true;
        }

        Stack<Character> stack = new Stack<Character>();
        ArrayList<Character> formatFront = new ArrayList<Character>();
        formatFront.add('(');
        formatFront.add('{');
        formatFront.add('[');
        ArrayList<Character> formatBack = new ArrayList<Character>();
        formatBack.add(')');
        formatBack.add('}');
        formatBack.add(']');

        for (Character c : s.toCharArray()) {
        	if (formatFront.contains(c)) {
        		stack.push(c);
        	}
        	else if (formatBack.contains(c)) {
        		if (!stack.isEmpty() && helper(stack.peek(), c)) {
        			stack.pop();
        		}
        		else {
        			return false;
        		}
        	}
        	else {
        		return false;
        	}
        }

        return stack.isEmpty();
    }

    private boolean helper(char c1, char c2) {
    	return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
    }
}
