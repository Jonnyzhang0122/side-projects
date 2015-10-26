// Best Time to Buy and Sell Stock III Total Accepted: 34226 Total Submissions: 143732 My Submissions Question Solution 
// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most two transactions.

// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

// Hide Tags Array Dynamic Programming

public class BestTimeIII {
    // public int maxProfit(int[] prices) {
    //     if (prices == null || prices.length == 0) {
    //     	return 0;
    //     }

    //     int min = prices[0];
    //     int max = prices[prices.length - 1];
    //     int[] tableLeft = new int[prices.length];
    //     int[] tableRight = new int[prices.length];
    //     tableLeft[0] = 0;
    //     tableRight[prices.length - 1] = 0;

    //     for (int i = 1; i < prices.length - 1; ++i) {
    //     	if (prices[i] < min) {
    //     		min = prices[i];
    //     	}
    //     	tableLeft[i] = Math.max(prices[i] - min, tableLeft[i - 1]);
    //     }

    //     for (int i = prices.length - 2; i >= 0; --i) {
    //     	if (prices[i] > max) {
    //     		max = prices[i];
    //     	}
    //     	tableRight[i] = Math.max(max - prices[i], tableRight[i + 1]);
    //     }

    //     int profit = 0;
    //     for (int i = 0; i < prices.length - 1; ++i) {
    //     	if (tableLeft[i] + tableRight[i] > profit) {
    //     		profit = tableLeft[i] + tableRight[i];
    //     	}
    //     }

    //     return profit;
    // }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        
        // left table to store the max profit we could gain before this day
        int[] leftDP = new int[len];
        // right table to store the max profit we could gain after this day
        int [] rightDP = new int[len];
        
        int min = prices[0];
        leftDP[0] = 0;
        for (int i = 1; i < len; ++i) {
            min = Math.min(min, prices[i]);
            leftDP[i] = Math.max(leftDP[i - 1], prices[i] - min);
        }
        
        int max = prices[len - 1];
        rightDP[len - 1] = 0;
        for (int i = len - 2; i >= 0; --i) {
            max = Math.max(max, prices[i]);
            rightDP[i] = Math.max(rightDP[i + 1], max - prices[i]);
        }
        
        int res = 0;
        for (int i = 0; i < len; ++i) {
            res = Math.max(res, leftDP[i] + rightDP[i]);
        }
        
        return res;
    }
}