// improved O(n) solution
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> queue = new LinkedList<>();
        inorder(root, target, k, queue);
        return (List)queue;
    }
    
    // return true means truely end, false means 
    private boolean inorder(TreeNode root, double target, int k, Queue<Integer> queue) {
        if (root == null) return false;
        
        if (inorder(root.left, target, k, queue)) return true;
        
        if (queue.size() == k) {
            if (Math.abs((double)queue.peek() - target) < Math.abs((double)root.val - target)) {
                return true;
            }
            queue.poll();
        }
        queue.offer(root.val);
        
        return inorder(root.right, target, k, queue);
    }
}


// inorder travelsal solution
public class Solution {
    private class Candidate {
        int val;
        double diff;
        public Candidate(int val, double diff) {
            this.val = val;
            this.diff = diff;
        }
    }
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        PriorityQueue<Candidate> maxHeap = new PriorityQueue<Candidate>((a, b) -> {
                if (b.diff == a.diff) return 0;
                else if (b.diff > a.diff) return 1;
                else return -1;
            });
        inorder(root, target, k, maxHeap);
        for (Candidate c : maxHeap) {
            res.add(c.val);
        }
        return res;
    }
    
    private void inorder(TreeNode root, double target, int k, PriorityQueue<Candidate> maxHeap) {
        if (root == null) return;
        inorder(root.left, target, k, maxHeap);
        
        maxHeap.offer(new Candidate(root.val, Math.abs((double)root.val - target)));
        if (maxHeap.size() > k) {
            // early pruning
            if (root.val == maxHeap.poll().val) {
                return;
            }
        }
        
        inorder(root.right, target, k, maxHeap);
    }
}