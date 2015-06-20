// Unique Paths II Total Accepted: 36545 Total Submissions: 130542 My Submissions Question Solution 
// Follow up for "Unique Paths":

// Now consider if some obstacles are added to the grids. How many unique paths would there be?

// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.

// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.

// Note: m and n will be at most 100.

// Hide Tags Array Dynamic Programming

public class UniquePathsII {
	private int[][] table;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
        	return 0;
        }
        if (obstacleGrid.length == 1 || obstacleGrid[0].length == 1) {
        	int temp = 0;
        	for (int i = 0; i < obstacleGrid.length; ++i) {
        		for (int j = 0; j < obstacleGrid[0].length; ++j) {
        			temp += obstacleGrid[i][j];
        		}
        	}
        	if (temp == 0) {
        		return 1;
        	}
        	else {
        		return 0;
        	}
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        table = new int[row][col];

        int last = 0;
        for (int i = 0; i < col; ++i) {
        	if (obstacleGrid[0][i] == 1) {
	        	table[0][i] = 0;
	        	last = 1;
        	}
        	else {
        		if (last == 0) {
		        	table[0][i] = 1;
        		}
        		else {
        			table[0][i] = 0;
        		}
        	}
        }
        last = 0;

        for (int i = 0; i < row; ++i) {
        	if (obstacleGrid[i][0] == 1) {
	        	table[i][0] = 0;
	        	last = 1;
        	}
        	else {
        		if (last == 0) {
		        	table[i][0] = 1;
        		}
        		else {
        			table[i][0] = 0;
        		}
        	}        	
        }

        for (int i = 1; i < row; ++i) {
        	for (int j = 1; j< col; ++j) {
        		if (obstacleGrid[i][j] == 1) {
        			table[i][j] = 0;
        		}
        		else {
        			table[i][j] = table[i - 1][j] + table[i][j - 1];
        		}
        	}
        }

        return table[row - 1][col - 1];
    }
}