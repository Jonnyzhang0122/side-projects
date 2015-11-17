// Medium Coins in a Line II

// 29% Accepted
// There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.

// Could you please decide the first player will win or lose?

// Have you met this question in a real interview? Yes
// Example
// Given values array A = [1,2,2], return true.

// Given A = [1,2,4], return false.

// Tags Expand 
// Dynamic Programming Array Game Theory

public class Coins2 {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
    	if (values.length <= 2) {
    		return true;
    	}

        // dp stores the max amount the player could take in current position
    	int[] dp = new int[values.length + 1];
    	dp[values.length] = 0;
    	dp[values.length - 1] = values[values.length - 1];
    	dp[values.length - 2] = values[values.length - 2] + values[values.length - 1];
    	dp[values.length - 3] = values[values.length - 3] + values[values.length - 2];

    	int solution1, solution2;
    	for (int i = values.length - 4; i >= 0; --i) {
            // two situation
            // use min() because the other player would choose the best
            // 1: the player just took current coin
    		solution1 = values[i] + Math.min(dp[i + 1 + 1], dp[i + 1 + 2]);
            // 2: the player took both curent and previous coins
    		solution2 = values[i] + values[i + 1] + Math.min(dp[i + 2 + 1], dp[i + 2 + 2]);
            // use max() because this player would choose the best
    		dp[i] = Math.max(solution1, solution2);
    	}

    	int sum = 0;
    	for (int v : values) {
    		sum += v;
    	}
    	if (dp[0] > sum - dp[0]) {
    		return true;
    	}
    	return false;
    }
}
