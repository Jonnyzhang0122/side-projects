// Valid Anagram My Submissions Question Solution 
// Total Accepted: 21414 Total Submissions: 61962 Difficulty: Easy
// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.

// Hide Tags Hash Table Sort
// Hide Similar Problems (M) Group Anagrams (E) Palindrome Permutation

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        
        int len = s.length();
        
        int[] tNum = new int[len];
        int[] sNum = new int[len];
        
        for (int i = 0; i < len; ++i) {
            sNum[i] = (int)(t.charAt(i) - 'a');
            tNum[i] = (int)(s.charAt(i) - 'a');
        }
        
        Arrays.sort(sNum);
        Arrays.sort(tNum);
        
        for (int i = 0; i < len; ++i) {
            if (sNum[i] != tNum[i]) {
                return false;
            }
        }
        
        return true;
    }
}
