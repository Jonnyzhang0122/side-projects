
public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if (s.charAt(0) <= '9' && s.charAt(0) >= '1') {
            dp[1] = 1;
        }
        else {
            return 0;
        }
        
        for (int i  = 2; i < len + 1; ++i) {
            boolean flag = false;
            char former = s.charAt(i - 2), current = s.charAt(i - 1);
            // judge if the char is valid
            if (current > '9' || current < '0') {
                return 0;
            }
            
            // judge if current letter can combine with the former letter
            if (former <= '2' && former >= '1') {
                if (former == '1') {
                    if (current <= '9' && current > '0') {
                        flag = true;
                    }
                }
                else {
                    if (current <= '6' && current > '0') {
                        flag = true;
                    }
                }
                // resetting last table bit if the '0' if needed
                if (current == '0') {
                    dp[i - 1] = dp[i - 2];
                }
            }
            else {
                // check invalid 0
                if (current == '0') {
                    return 0;
                }
            }

            dp[i] += dp[i - 1];
            if (flag) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[len];
    }
}
