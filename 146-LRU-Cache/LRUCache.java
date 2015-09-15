import java.util.*;

public class LRUCache {
    /*
    // unwork version, cause we could not random delete an element from the queue(linked list)
    private Queue<Integer> used = new LinkedList<Integer>();
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int cap;
    
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            // update the queue
            used.offer(key);
            used.poll();
            return map.get(key);
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        map.put(key, value);
        used.offer(key);
        if (used.size() > cap) {
            int expired = used.poll();
            map.remove(expired);
        }
    }
    */

    public class Node {
        private int key = -1;
        private int val;
        private Node next = null, prev = null;

        public Node(int value) {
            val = value;
        }

        public void setKey(int k) {
            key = k;
        }

        public int getKey() {
            return key;
        }

        public void setNext(Node n) {
            next = n;
            n.prev = this;
        }

        public void setPrev(Node p) {
            prev = p;
            p.next = this;
        }

        public void remove() {
            prev.next = next;
            next.prev = prev;
        }

        public void putBefore(Node h) {
            next = h;
            prev = h.prev;
            prev.next = this;
            h.prev = this;
        }
    }
    
    private Node headDum = new Node(0), tailDum = new Node(0);
    private int cap;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public LRUCache(int capacity) {
        cap = capacity;
        headDum.next = tailDum;
        tailDum.prev = headDum;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            // disconnect it first
            cur.remove();
            // move to the head as the newest element
            cur.putBefore(headDum.next);
            return cur.val;
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            //create new node and set up the key and value
            Node cur = new Node(value);
            cur.setKey(key);
            // move to the head as the newest element
            cur.putBefore(headDum.next);
            // if exceed the capacity of cache, remove the oldest one, which is the tail
            if (map.size() == cap) {
                // remove the key from map
                map.remove(tailDum.prev.getKey());
                // delete the node from list
                tailDum.prev.remove();
            }
            // at last, put the new node into map
            map.put(key, cur);
        }
        else {
            Node cur = map.get(key);
            cur.val = value;
            // disconnect it first
            cur.remove();
            // move to the head as the newest element
            cur.putBefore(headDum.next);
        }
    }

    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.set(2, 1);
        test.set(1, 1);
        System.out.println(test.get(2));
        test.set(4, 1);
        System.out.println(test.get(1));
        System.out.println(test.get(2));
    }
}