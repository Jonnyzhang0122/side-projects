// Search a 2D Matrix Total Accepted: 37399 Total Submissions: 118982 My Submissions Question Solution 
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:

// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.

// Hide Tags Array Binary Search

public class SearchA2DMatrix {
    
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null) {
        	return false;
        }

        int startRow = 0;
        int endRow = matrix.length - 1;
        int midRow;

        while (startRow + 1 < endRow) {
        	midRow = startRow + (endRow - startRow) / 2;
        	if (matrix[midRow][0] == target) {
        		return true;
        	}
        	else if (matrix[midRow][0] > target) {
        		endRow = midRow;
        	}
        	else if (matrix[midRow][0] < target) {
        		startRow = midRow;
        	}
        }

        int row;
        if (matrix[startRow][0] == target) {
        	return true;
        }
        if (matrix[endRow][0] == target) {
        	return true;
        }
        if (matrix[startRow][0] > target) {
        	return false;
        }
        if (matrix[endRow][0] < target) {
        	row = endRow;
        }
        else {
            row = startRow;
        }

        int start = 0;
        int end = matrix[0].length - 1;
        int mid;

        while (start + 1 < end) {
        	mid = start + (end - start) / 2;
        	if (matrix[row][mid] == target) {
        		return true;
        	}
        	else if (matrix[row][mid] > target) {
        		end = mid;
        	}
        	else if (matrix[row][mid] < target) {
        		start = mid;
        	}
        }

        if (matrix[row][start] == target) {
        	return true;
        }
        if (matrix[row][end] == target) {
        	return true;
        }

        return false;

    }

    public static void main(String[] args) {
    	SearchA2DMatrix A = new SearchA2DMatrix();
    	int[][] B = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
    	System.out.println(A.searchMatrix(B, 16));
    }
}