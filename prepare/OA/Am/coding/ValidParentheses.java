import java.util.*;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s.length() == 0 || s.length() % 2 != 0) {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); ++i) {
			char cur = s.charAt(i);
			if (isFirst(cur)) {
				stack.push(cur);
			}
			else {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != getPair(cur)) {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean isFirst(char first) {
		if (first == '(' || first == '[' || first == '{') {
			return true;
		}
		return false;
	}

	private char getPair(char second) {
		if (second == ')') {
			return '(';
		}
		else if (second == ']') {
			return '[';
		}
		else {
			return '{';
		}
	}
}
