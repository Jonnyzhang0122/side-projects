// Balanced Binary Tree Total Accepted: 57937 Total Submissions: 180772 My Submissions Question Solution 
// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

// Hide Tags Tree Depth-first Search
// Have you met this question in a real interview? Yes  No
// Discuss

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalanceTree {
    public boolean isBalanced(TreeNode root) {
        if (maxDepth(root) == -1) {
        	return false;
        }

        return true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
        	return -1;
        }

        return Math.max(left, right) + 1;
    }
}