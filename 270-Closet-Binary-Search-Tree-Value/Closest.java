// wrong answer
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// public class Solution {
//     public int closestValue(TreeNode root, double target) {
//         int prevVal = -1;
//         double curDiff = Double.MAX_VALUE;
//         double prevDiff;
//         while (root != null) {
//             prevDiff = curDiff;
//             curDiff = Math.abs(target - (double)root.val);
//             System.out.println(root.val + " " + curDiff);
//             if (curDiff > prevDiff) {
//                 break;
//             }
//             prevVal = root.val;
//             if ((double)root.val < target) {
//                 root = root.right;
//             }
//             else if ((double)root.val > target) {
//                 root = root.left;
//             }
//             else {
//                 return root.val;
//             }
//         }
        
//         return prevVal;
//     }
// }


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int curVal = root.val;
        
        // choose where to go
        TreeNode next;
        if ((double)root.val > target) {
            next = root.left;
        }
        else if ((double)root.val < target) {
            next = root.right;
        }
        else {
            return curVal;
        }
        
        if (next == null) {
            return curVal;
        }
        
        // get children's closest value
        int childVal = closestValue(next, target);
        
        // return the closest one
        if (Math.abs((double)curVal - target) <= Math.abs((double)childVal - target)) {
            return curVal;
        }
        else {
            return childVal;
        }
    }
}

