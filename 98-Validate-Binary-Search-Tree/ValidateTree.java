// Validate Binary Search Tree Total Accepted: 49807 Total Submissions: 240109 My Submissions Question Solution 
// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
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
public class ValidateTree {
  //   public boolean isValidBST(TreeNode root) {
  //   	if (root == null) {
  //   		return true;
  //   	}
 
  //   	// 0 means left child, 1 means right child, 2 means root
  //   	return helper(root, 0, 2);
  //   	// return helper(root.left, root.val, 0) && helper(root.right, root.val, 1);
  //   }

  //   public boolean helper(TreeNode root, int parentVal, int whichSide) {
		// if (root == null) {
  //   		return true;
  //   	}

  //   	boolean left = true;
  //   	boolean right = true;
  //   	if (root.left != null) {
  //   		if (root.left.val >= root.val) {
  //   			left = false;
  //   		}
  //   		if (whichSide == 1 && root.left.val <= parentVal) {
  //   			right = false;
  //   		}
  //   	}
  //   	if (root.right != null) {
  //   		if (root.right.val <= root.val) {
  //   			right = false;
  //   		}
  //   		if (whichSide == 0 && root.right.val >= parentVal) {
  //   			left = false;
  //   		}
  //   	}
        
  //       if (left && right) {
  //       	return helper(root.left, Math.root.val, 0) && helper(root.right, root.val, 1);
  //       }
  //       else {
  //       	return false;
  //       }
  //   }

    // public boolean isValidBST(TreeNode root) {
    //     // // just for the tricky test case
    //     // if (root == null) {
    //     //     return true;
    //     // }
    //     // if (root.left == null && root.right == null) {
    //     //     return true;
    //     // }

    //     return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    // }

    // public boolean helper(TreeNode root, int minVal, int maxVal) {
    //     if (root == null) {
    //         return true;
    //     }

    //     if (root.val <= minVal || root.val >= maxVal) {
    //         return false;
    //     }

    //     return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    // }

    int currMax = Integer.MIN_VALUE;
    int flag = 1;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        return helper(root);
    }

    public boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (helper(root.left) == false) {
            return false;
        }
        if (root.val <= currMax) {
            if (currMax == Integer.MIN_VALUE && flag == 1) {
                flag = 0;
            }
            else {
                return false;
            }
        }
        currMax = root.val;

        return helper(root.right);
    }
}