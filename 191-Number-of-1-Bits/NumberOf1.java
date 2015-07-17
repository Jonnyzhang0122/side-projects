// Number of 1 Bits Total Accepted: 37987 Total Submissions: 101078 My Submissions Question Solution 
// Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

// For example, the 32-bit integer '11' has binary representation 00000000000000000000000000001011, so the function should return 3.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Hide Tags Bit Manipulation
// Hide Similar Problems (E) Reverse Bits (E) Power of Two

public class NumberOf1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; ++i) {
        	if ((n & 1) == 1) {
        		++count;
        	}
        	n  = n >> 1;
        }

        return count;
    }

    public static void main(String[] args) {
    	NumberOf1 A = new NumberOf1();
    	// System.out.println("count: " + A.hammingWeight(-2147483647));
    	System.out.println("count: " + A.hammingWeight(Integer.MIN_VALUE + 1));
    }
}
