// String to Integer (atoi) Total Accepted: 53708 Total Submissions: 414047 My Submissions Question Solution 
// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

// Update (2015-02-10):
// The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

// spoilers alert... click to show requirements for atoi.

// Requirements for atoi:
// The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

// The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

// If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

// If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

// Hide Tags Math String

import java.util.*;

public class Atoi {
    public int myAtoi(String str) {
        if (str == null || str.equals("") || str.length() == 0) {
        	return 0;
        }

        int pos = 0;
        int len = str.length();
        boolean flag = false;
        while (pos < len && str.charAt(pos) == ' ') {
        	++pos;
        }
        int sign = 1;
        if (pos < len && (str.charAt(pos) == '-' || str.charAt(pos) ==  '+')) {
        	if (str.charAt(pos) == '-') {
        		sign = -1;
        	}
        	++pos;
        }
        if (pos < len && !isNumber(str.charAt(pos))) {
        	return 0;
        }
        long result = 0;
        int temp;
        while (pos < len && isNumber(str.charAt(pos))) {
        	flag = true;
        	temp = str.charAt(pos) - '0';
        	result = result * 10 + temp;
        	System.out.println(result);
        	if (result >= Integer.MAX_VALUE && sign == 1) {
        		return Integer.MAX_VALUE;
        	}
        	if (result > Integer.MAX_VALUE && sign == -1) {
        		return Integer.MIN_VALUE;
        	}
        	++pos;
        }

        if (flag) {
	        return sign * (int)result;
        }
        else {
        	return 0;
        }
    }

    private boolean isNumber(char c) {
    	if (c >= '0' && c <= '9') {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public static void main(String[] args) {
    	Atoi A = new Atoi();
    	System.out.println(A.myAtoi(" -2147483647"));
    }
}
