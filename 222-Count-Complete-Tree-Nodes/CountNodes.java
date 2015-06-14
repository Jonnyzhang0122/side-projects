// Count Complete Tree Nodes Total Accepted: 2840 Total Submissions: 14427 My Submissions Question Solution 
// Given a complete binary tree, count the number of nodes.

// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

// Hide Tags Tree Binary Search

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountNodes {
	// /*normal recursion surpass time limit*/
	// private int nodeNum = 0;

 //    public int countNodes(TreeNode root) {
 //        if (root == null) {
 //        	return 0;
 //        }

 //        ++nodeNum;
 //        countNodes(root.left);
 //        countNodes(root.right);

 //        return nodeNum;
 //    }

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		int leftHeight = 0;
		int rightHeight = 0;
		TreeNode left = root.left;
		TreeNode right = root.right;
		while (left != null) {
			++leftHeight;
			left = left.left;
		}
		while (right != null) {
			++rightHeight;
			right = right.right;
		}
		if (leftHeight == rightHeight) {
			return (int) Math.pow(2, leftHeight + 1) - 1;
		}

		else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
    }
}