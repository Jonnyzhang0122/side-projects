// Binary Tree Right Side View Total Accepted: 13754 Total Submissions: 50505 My Submissions Question Solution 
// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// For example:
// Given the following binary tree,
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].

// Credits:
// Special thanks to @amrsaqr for adding this problem and creating all test cases.

// Hide Tags Tree Depth-first Search Breadth-first Search
// Hide Similar Problems (M) Populating Next Right Pointers in Each Node

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RightSide {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
        	return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int size;
        queue.offer(root);
        TreeNode temp;
        int flag;
        result.add(root.val);
        while (!queue.isEmpty()) {
        	size = queue.size();
        	flag = 0;
        	for (int i = 0; i < size; ++i) {
        		temp = queue.peek();
        		queue.poll();
        		if (temp.right != null) {
        			queue.offer(temp.right);
        			if (flag == 0) {
        				result.add(temp.right.val);
        				flag = 1;
        			}
        		}
        		if (temp.left != null) {
        			queue.offer(temp.left);
        			if (flag == 0) {
        				result.add(temp.left.val);
        				flag = 1;
        			}
        		}
        	}
        }

        return result;
    }
}
