import java.util.*;

public class MergeKLists {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}

		// create a min heap
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));
		// put the first k head nodes into heap
		for (ListNode cur : lists) {
			// take care of the null lists
			if (cur != null) {
				heap.offer(cur);
			}
		}
		ListNode dum = new ListNode(0);
		ListNode prev = dum;
		while (!heap.isEmpty()) {
			// get the min node from the heap
			ListNode cur = heap.poll();
			if (cur.next != null) {
				heap.offer(cur.next);
			}
			// link the polled node
			prev.next = cur;
			prev = cur;
		}
		return dum.next;
	}
}