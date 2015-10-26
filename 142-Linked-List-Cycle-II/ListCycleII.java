// Linked List Cycle II Total Accepted: 47227 Total Submissions: 150562 My Submissions Question Solution 
// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Follow up:
// Can you solve it without using extra space?

// Show Tags
// Show Similar Problems

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ListCycleII {
    // public ListNode detectCycle(ListNode head) {
    //     if (head == null) {
    //     	return null;
    //     }

    //     int flag = 0;
    //     ListNode slow = head, fast = head;
    //     while(fast.next != null && fast.next.next != null) {
    //     	slow = slow.next;
    //     	fast = fast.next.next;
    //     	if (slow == fast) {
    //     		flag = 1;
    //     		break;
    //     	}
    //     }

    //     if (flag == 1) {
    //     	slow = head;
    //     	while (slow != fast) {
    //     		slow = slow.next;
    //     		fast = fast.next;
    //     	}
    //     	return slow;
    //     }
    //     else {
    //     	return null;
    //     }
    // }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        
        boolean flag = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        
        if (!flag) {
            return null;
        }
        
        slow = head;
        while (true) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }
}
