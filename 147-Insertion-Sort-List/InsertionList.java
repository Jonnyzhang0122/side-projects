// Insertion Sort List Total Accepted: 46367 Total Submissions: 174901 My Submissions Question Solution 
// Sort a linked list using insertion sort.

// Hide Tags Linked List Sort
// Hide Similar Problems (M) Sort List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionList {
    // untest
    // public ListNode insertionSortList(ListNode head) {
    //     if (head == null || head.next == null) {
    //     	return head;
    //     }

    //     ListNode dummy = new ListNode(Integer.MIN_VALUE);
    //     dummy.next = head;
    //     int sortNum = 2;
    //     int count = 2;
    //     head = dummy;
    //     ListNode temp1, temp2;
    //     while (head.next != null && head.next.next != null) {
    //     	head = dummy;
    //     	count = 2;
    //     	while (head.next != null && head.next.next != null) {
    //     		if (head.next.val > head.next.next.val) {
    //     			temp1 = head.next;
    //     			temp2 = head.next.next.next;
    //     			head.next = head.next.next;
    //     			head.next.next = temp1;
    //     			head.next.next.next = temp2;
    //     		}
    //     		++count;
    //     		if (count > sortSum) {
    //     			break;
    //     		}
    //     		head = head.next;
    //     	}
    //     	++sortSum;
    //     }

    // }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode cur = dummy;

            // find the correct position(between cur and cur.next) in the new list to insert
            while (cur.next != null && cur.next.val <= head.val) {
                cur = cur.next;
            }

            //now insert the node(head) and disconnect it from the old list
            ListNode temp = head.next;
            head.next = cur.next;
            cur.next = head;
            head = temp;
        }

        return dummy.next;
    }
}
