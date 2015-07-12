// Merge Two Sorted Lists Total Accepted: 65828 Total Submissions: 202086 My Submissions Question Solution 
// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

// Hide Tags Linked List
// Hide Similar Problems (H) Merge k Sorted Lists (E) Merge Sorted Array

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwo {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
        	return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
        	if (l1.val <= l2.val) {
        		cur.next = l1;
        		l1 = l1.next;
        	}
        	else {
        		cur.next = l2;
        		l2 = l2.next;
        	}
        		cur = cur.next;
        }
        if (l1 == null) {
        	cur.next = l2;
        }
        else if (l2 == null) {
        	cur.next = l1;
        }

        return dummy.next;
    }
}
