// Same Tree Total Accepted: 63119 Total Submissions: 150692 My Submissions Question Solution 
// Given two binary trees, write a function to check if they are equal or not.

// Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

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
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if (p == null && q == null) {
    		return true;
    	}
    	if (p == null || q == null) {
    		return false;
    	}
        if (p.val != q.val) {
        	return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
    	SameTree A = new SameTree();
    	TreeNode p = new TreeNode(0);
    	p.left = null;
    	p.right = null;
		TreeNode q = new TreeNode(0);
    	q.left = null;
    	q.right = null;
    	System.out.println(A.isSameTree(p, q));    
    }
}