// Path Sum II Total Accepted: 45217 Total Submissions: 169587 My Submissions Question Solution 
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]
// Hide Tags Tree Depth-first Search

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PathSumII {
	private ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    
    // find correct path and modified the result list
    private void findPathHelper(TreeNode root, ArrayList<Integer> path, int sum, int pathSum) {
    	path.add(root.val);
		pathSum += root.val;
		// if touch the bottom, check the path sum
    	if (root.left == null && root.right == null) {
    		if (pathSum == sum) {
    			result.add(new ArrayList<Integer>(path));
    		}
    	}

    	if (root.left != null) {
    		findPathHelper(root.left, path, sum, pathSum);
    	}
    	if (root.right != null) {
    		findPathHelper(root.right, path, sum, pathSum);
    	}

    	// this node is already visited, now remove it from the path
		path.remove(path.size() - 1);
		return;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	if (root == null) {
    		return result;
    	}
	    // ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
	    ArrayList<Integer> path = new ArrayList<Integer>();

    	findPathHelper(root, path, sum, 0);
    	return result;
    }

    public static void main(String[] args) {
    	PathSumII A = new PathSumII();
    	TreeNode root = new TreeNode(1);
    	System.out.println(A.pathSum(root, 1));
    }
}