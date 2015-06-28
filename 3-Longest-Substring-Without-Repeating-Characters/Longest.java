// Longest Substring Without Repeating Characters Total Accepted: 72789 Total Submissions: 353671 My Submissions Question Solution 
// Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

// Hide Tags Hash Table Two Pointers String

import java.util.*;

public class Longest {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0 || s.equals("")) {
        	return 0;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 1;
        int i = 0;
        int j = 0;
    	while (j < s.length()) {
        	if (!map.containsKey(s.charAt(j))) {
        		map.put(s.charAt(j), j);
        		max = Math.max(max, j - i + 1);
        		++j;
        	}
        	else {
        		while (map.containsKey(s.charAt(j))) {
        			map.remove(s.charAt(i));
        			++i;
        		}
        	}
    	}

        return max;
    }

    public static void main(String[] args) {
    	Longest A = new Longest();
    	String s = "cdd";
    	System.out.println(A.lengthOfLongestSubstring(s));
    }
}