// Symmetric Tree Total Accepted: 58177 Total Submissions: 184223 My Submissions Question Solution 
// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.

// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

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
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) {
    		return true;
    	}

        return symHelper(root.left, root.right);
    }

    public boolean symHelper(TreeNode left, TreeNode right) {
    	if (left == null && right == null) {
    		return true;
    	}
    	else if (left != null && right != null) {
    		return left.val == right.val && symHelper(left.left, right.right) && symHelper(left.right, right.left);
    	}
    	else {
    		return false;
    	}
    }
}