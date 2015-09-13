
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE, changeFlag = 0, sameFlag = 0;
        
        if (word1.equals(word2)) {
            sameFlag = 1;
        }
        
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                changeFlag = 1;
                if (sameFlag == 0) {
                    index1 = i;
                }
                else {
                    index2 = index1;
                    index1 = i;
                }
                
            }
            else if (words[i].equals(word2) && sameFlag ==0) {
                changeFlag = 1;
                index2 = i;
            }
            
            if (changeFlag == 1) {
                changeFlag = 0;
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
