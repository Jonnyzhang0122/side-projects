// Binary Tree Zigzag Level Order Traversal Total Accepted: 34639 Total Submissions: 131308 My Submissions Question Solution 
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

// Hide Tags Tree Breadth-first Search Stack

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

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
        	return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int size;
        TreeNode curr;
        Boolean reverse = false;
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

        	if (reverse) {
        		Collections.reverse(path);
        	}
        	reverse = !reverse;
        	result.add(path);
        }

        return result;
    }
}