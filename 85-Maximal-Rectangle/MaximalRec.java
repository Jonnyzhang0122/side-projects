// Maximal Rectangle Total Accepted: 25766 Total Submissions: 117108 My Submissions Question Solution 
// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

// Hide Tags Array Hash Table Stack Dynamic Programming

public class MaximalRec {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }

 		int maxArea = 0;
        int[][] table = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
        	if (matrix[i][0] == '1') {
        		table[i][0] = 1;
        	}
        }
        for (int i = 0; i < matrix.length; ++i) {
        	for (int j = 1; j < matrix[0].length; ++j) {
        		if (matrix[i][j] == '1') {
        			table[i][j] = table[i][j - 1] + 1;
        		}
        	}
        }

 		for (int i = 0; i < matrix.length; ++i) {
 			for (int j = 0; j < matrix[0].length; ++j) {
 				maxArea = Math.max(maxArea, localMax(i, j, table));
 			}
 		}

 		return maxArea;
    }

    private int localMax(int rowPos, int colPos, int[][] table) {
    	if (table[rowPos][colPos] == 0) {
    		return 0;
    	}
    	int height = 1;
    	int width = table[rowPos][colPos];

    	for (int i = rowPos - 1; i >= 0; --i) {
    		if (table[i][colPos] < width) {
    			break;
    		}
    		++height;
    	}

    	for (int i = rowPos + 1; i < table.length; ++i) {
    		if (table[i][colPos] < width) {
    			break;
    		}
    		++height;
    	}

    	return height * width;
    }
}
