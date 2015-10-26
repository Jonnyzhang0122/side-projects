
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        // queue to do BFS traversal
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        // HashMap used as visited bits and save the new nodes
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        
        // clone the root
        UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
        // put newRoot into map
        map.put(newRoot.label, newRoot);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode originalNode = queue.poll();
            UndirectedGraphNode cloneNode = map.get(originalNode.label);
            
            for (int i = 0; i < originalNode.neighbors.size(); ++i) {
                UndirectedGraphNode originalNei = originalNode.neighbors.get(i);
                UndirectedGraphNode cloneNei;
                // clone this neighbors if necessary
                if (!map.containsKey(originalNei.label)) {
                    cloneNei = new UndirectedGraphNode(originalNei.label);
                    map.put(originalNei.label, cloneNei);
                    // add the none finished node into queue
                    queue.offer(originalNei);
                }
                else {
                    cloneNei = map.get(originalNei.label);
                }
                
                // add this neighbors into neighbor list
                cloneNode.neighbors.add(cloneNei);
            }
        }
        
        return newRoot;
    }
}
