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

// rewrote
// public class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); ++i) {
//         	char cur = s.charAt(i);
//         	if (isFirstHalf(cur)) {
//         		stack.push(cur);
//         	}
//         	else {
//         		if (stack.isEmpty() || stack.pop() != getFirstHalf(cur)) {
//         			return false;
//         		}
//         	}
//         }
//         return stack.size() == 0;
//     }

//     private boolean isFirstHalf(char cur) {
//     	if (cur == '(' || cur == '{' || cur == '[') {
//     		return true;
//     	}
//     	return false;
//     }

//     private char getFirstHalf(char cur) {
//     	if (cur == ')') {
//     		return '(';
//     	}
//     	else if (cur == '}') {
//     		return '{';
//     	}
//     	else {
//     		return '[';
//     	}
//     }
// }
