// neat version
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            int remain = i - j * j;
            while (remain >= 0) {
                min = Math.min(dp[remain] + 1, min);
                ++j;
                remain = i - j * j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}

// wrong version
public class Solution {
    public int numSquares(int n) {
        return helper(n, 0);
    }
    
    private int closestSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt;
    }
    
    private int helper(int n, int count) {
        if (n == 0) {
            return count;
        }
        return helper(n - closestSquare(n), count + 1);
    }
}