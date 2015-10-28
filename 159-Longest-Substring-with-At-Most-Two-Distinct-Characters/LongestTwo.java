
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int curHead = 0;
        int max = 0;
        
        for (int i = 0; i < len; ++i) {
            char cur = s.charAt(i);
            // if the new char is not qualified for being added to the substring
            if (map.size() >= 2 && !map.containsKey(cur)) {
                while (map.size() >= 2) {
                    char head = s.charAt(curHead);
                    int count = map.get(head) - 1;
                    if (count == 0) {
                        map.remove(head);
                    }
                    else {
                        map.put(head, count);
                    }
                    ++curHead;
                }
            }
            // if it is originally qualified or now it is qualified
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            }
            else {
                map.put(cur, 1);
            }
            max = Math.max(max, i - curHead + 1);
        }
        
        return max;
    }
}
