import java.util.*;

public class InsertValue {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	public static void insert(ListNode cur, int insert) {
		if (cur == null) {
			return;
		}
		ListNode insertNode = new ListNode(insert);
		// if only one node
		if (cur.next == cur) {
			cur.next = insertNode;
			insertNode.next = cur;
			return;
		}

		// first gain the min and max nodes
		// also save the original node to avoid the case all numbers are the same
		ListNode prev = cur, ori = cur, min, max;
		cur = cur.next;
		while (cur.val >= prev.val) {
			// if loop through once without discovering min or max, the all same case
			if (cur == ori) {
				// insert between cur and prev
				prev.next = insertNode;
				insertNode.next = cur;
				return;
			}
			prev = cur;
			cur = cur.next;
		}
		// discovered the min and max
		min = cur;
		max = prev;

		// check edge case, insert > max or insert < min, put between min and max
		if (insert <= min.val || insert >= max.val) {
			max.next = insertNode;
			insertNode.next = min;
			return;
		}

		// loop again to find correct position to insert
		prev = min;
		cur = min.next;
		while (insert > cur.val) {
			prev = cur;
			cur = cur.next;
		}
		// now insert the new node before cur node
		prev.next = insertNode;
		insertNode.next = cur;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		n1.next = n2;
		n2.next = n3;
		n3.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n1;

		InsertValue.insert(n6, 8);
		ListNode cur = n1;
		for (int i = 0; i < 9; ++i) {
			System.out.printf("%d ", cur.val);
			cur = cur.next;
		}
		System.out.println("");

		/*----------------------------------*/

		ListNode n11 = new ListNode(2);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(2);
		n11.next = n12;
		n12.next = n13;
		n13.next = n11;

		InsertValue.insert(n12, 8);
		cur = n11;
		for (int i = 0; i < 5; ++i) {
			System.out.printf("%d ", cur.val);
			cur = cur.next;
		}
		System.out.println("");

	}
}