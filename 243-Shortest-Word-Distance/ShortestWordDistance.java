
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE, flag = 0;
        
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                index1 = i;
                flag = 1;
            }
            else if (words[i].equals(word2)) {
                index2 = i;
                flag = 1;
            }
            if (flag == 1) {
                flag = 0;
                if (index1 != -1 && index2 != -1) {
                    int diff = Math.abs(index1 - index2);
                    if (diff < min) {
                        min = diff;
                    }                    
                }

            }
        }
        
        return min;
    }
}
