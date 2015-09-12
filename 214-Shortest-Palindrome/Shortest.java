// Shortest Palindrome Total Accepted: 6939 Total Submissions: 43081 My Submissions Question Solution 
// Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

// For example:

// Given "aacecaaa", return "aaacecaaa".

// Given "abcd", return "dcbabcd".

// Credits:
// Special thanks to @ifanchu for adding this problem and creating all test cases. Thanks to @Freezen for additional test cases.

// Hide Tags String
// Hide Similar Problems (M) Longest Palindromic Substring (E) Implement strStr()

public class Shortest {
    public String shortestPalindrome(String s) {
        StringBuilder rs = new StringBuilder(s).reverse();
        for (int i = 0; i < s.length(); ++i) {
        	if (s.startsWith(rs.substring(i))) {
        		return rs.substring(0, i) + s;
        	}
        }

        return s;
    }
}
