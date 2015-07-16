// Power of Two Total Accepted: 9833 Total Submissions: 32756 My Submissions Question Solution 
// Given an integer, write a function to determine if it is a power of two.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Hide Tags Math Bit Manipulation
// Hide Similar Problems (E) Number of 1 Bits

public class PowerTwo {
    public boolean isPowerOfTwo(int n) {
    	long nLong = n;
    	long base = 1;
    	while (true) {
    		if (nLong == base) {
    			return true;
    		}
    		else if (base > nLong) {
    			return false;
    		}
    		base = base << 1;
    	}
    }

    public static void main(String[] args) {
    	PowerTwo A = new PowerTwo();
    	System.out.println(A.isPowerOfTwo(1));
    }
}
