
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len == 0 || k == 0) {
            return 0;
        }
        // if k is large enough, it means actually we could do as many operation as we want
        // so the same situation as Stock II problem
        else if (k * 2 >= len) {
            return noLimit(prices);
        }
        
        // set up a table represent the profit we get after "index" times operations(buy or sell)
        int[] dp = new int[2 * k + 1];
        // the zero operation means nothing
        dp[0] = 0;
        // for the first day aspect, set dp[1] to min value
        // because if it is set to 0, then it would be larger than the first day's profit, when we are buying stocks
        for (int i = 1; i <= 2 * k; ++i) {
            dp[i] = Integer.MIN_VALUE;
        }
        // loop from the first day to the last day
        for (int i = 0; i < len; ++i) {
            // # of operations j could not surpass i, which is the # of day, or total allowed operations
            // loop from the first operation to the last possible operation
            for (int j = 1; j <= Math.min(i + 1, 2 * k); ++j) {
                // if odd day, then buy
                if (j % 2 == 1) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                }
                // if even day, then sell
                else {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }

        return dp[2 * k];
    }
    
    private int noLimit(int[] prices) {
        int profit = 0;
        // add up all increasing difference
        for (int i = 1; i < prices.length; ++i) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
}
