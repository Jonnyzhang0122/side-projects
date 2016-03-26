


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