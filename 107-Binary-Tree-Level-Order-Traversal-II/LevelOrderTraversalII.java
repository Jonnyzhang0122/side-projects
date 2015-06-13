// Binary Tree Level Order Traversal II Total Accepted: 42420 Total Submissions: 136392 My Submissions Question Solution 
// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

// Hide Tags Tree Breadth-first Search

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
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
        	return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
    
    	int size;
    	TreeNode curr;
    	while (!queue.isEmpty()) {
			ArrayList<Integer> path = new ArrayList<Integer>();
    		size = queue.size();
    		for (int i = 0; i < size; ++i) {
    			curr = queue.poll();
    			path.add(curr.val);
    			if (curr.left != null) {
    				queue.offer(curr.left);
    			}
    			if (curr.right != null) {
    				queue.offer(curr.right);
    			}
    		}

    		result.add(path);
    	}

        Collections.reverse(result);
    	return result;
    }
}