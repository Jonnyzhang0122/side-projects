// Construct Binary Tree from Inorder and Postorder Traversal Total Accepted: 32472 Total Submissions: 121028 My Submissions Question Solution 
// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

// Hide Tags Tree Array Depth-first Search

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class ConstructInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
        	return null;
        }
        if (inorder == null) {
        	return null;
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    	if (inStart > inEnd) {
    		return null;
    	}

    	TreeNode root = new TreeNode(postorder[postEnd]);
    	int rootIndex = getPostion(inorder, inStart, inEnd, root.val);
    	root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + rootIndex - 1 - inStart);
    	root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1);

    	return root;
    }

    private int getPostion(int[] nums, int start, int end, int target) {
    	for (int i = start; i <= end; ++i) {
    		if (nums[i] == target) {
    			return i;
    		}
    	}
		return -1;
    }

}