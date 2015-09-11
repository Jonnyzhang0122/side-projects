// Hard Coins in a Line III

// 30% Accepted
// There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins.

// Could you please decide the first player will win or lose?

// Have you met this question in a real interview? Yes
// Example
// Given array A = [3,2,2], return true.

// Given array A = [1,2,4], return true.

// Given array A = [1,20,4], return false.

// Challenge
// Follow Up Question:

// If n is even. Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?

// Tags Expand 
// Dynamic Programming Array Game Theory

public class Coins3 {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values.length <= 1) {
        	return true;
        }
        if (values.length == 2) {
        	if (values[0] == values[1]) {
        		return true;
        	}
        	return false;
        }

        int n = values.length;

        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i < dp.length; ++i) {
        	for (int j = 1; j < dp[0].length; ++j) {
        		dp[i][j] = Integer.MAX_VALUE;
        	}
        }

        for (int i = 1; i <= n; ++i) {
        	dp[i][i] = values[i - 1];
        }

        int solution1, solution2;
        for (int i = n; i >= 1; --i) {
        	for (int j = i + 1; j <= n; ++j) {
        		solution1 = values[i - 1] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
        		solution2 = values[j - 1] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
        		dp[i][j] = Math.max(solution1, solution2);
        	}
        }

        int sum = 0;
        for (int i = 0; i < n; ++i) {
        	sum += values[i];
        }

        System.out.println(dp[1][n]);
        return dp[1][n] > sum -dp[1][n];
    }

    public static void main(String args[]) {
    	int[] values = {1, 20, 4};
    	Coins3 A = new Coins3();
    	System.out.println(A.firstWillWin(values));
    }
}
