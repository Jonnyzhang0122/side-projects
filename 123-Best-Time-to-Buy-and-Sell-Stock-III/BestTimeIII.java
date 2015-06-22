// Best Time to Buy and Sell Stock III Total Accepted: 34226 Total Submissions: 143732 My Submissions Question Solution 
// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most two transactions.

// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

// Hide Tags Array Dynamic Programming

public class BestTimeIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
        	return 0;
        }

        int min = prices[0];
        int max = prices[prices.length - 1];
        int[] tableLeft = new int[prices.length];
        int[] tableRight = new int[prices.length];
        tableLeft[0] = 0;
        tableRight[prices.length - 1] = 0;

        for (int i = 1; i < prices.length - 1; ++i) {
        	if (prices[i] < min) {
        		min = prices[i];
        	}
        	tableLeft[i] = Math.max(prices[i] - min, tableLeft[i - 1]);
        }

        for (int i = prices.length - 2; i >= 0; --i) {
        	if (prices[i] > max) {
        		max = prices[i];
        	}
        	tableRight[i] = Math.max(max - prices[i], tableRight[i + 1]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
        	if (tableLeft[i] + tableRight[i] > profit) {
        		profit = tableLeft[i] + tableRight[i];
        	}
        }

        return profit;
    }
}