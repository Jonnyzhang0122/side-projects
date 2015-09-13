
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
