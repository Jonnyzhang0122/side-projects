// Factorial Trailing Zeroes Total Accepted: 29201 Total Submissions: 101749 My Submissions Question Solution 
// Given an integer n, return the number of trailing zeroes in n!.

// Note: Your solution should be in logarithmic time complexity.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Hide Tags Math
// Hide Similar Problems (M) Number of Digit One

public class TrailZero {
    public int trailingZeroes(int n) {
    	int result = 0;
    	while (n >= 5) {
    		n /= 5;
    		result += n;
    	}

        return result;
    }

    public static void main(String[] args) {
    	TrailZero A = new TrailZero();
    	System.out.println(A.trailingZeroes(30));
    }
}
