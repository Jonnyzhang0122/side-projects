// Remove Linked List Elements Total Accepted: 20825 Total Submissions: 80178 My Submissions Question Solution 
// Remove all elements from a linked list of integers that have value val.

// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5

// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.

// Hide Tags Linked List
// Hide Similar Problems (E) Remove Element (E) Delete Node in a Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null && head.next != null) {
            while (head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
    
    public static void main(String[] args) {
        RemoveElements A = new RemoveElements();
        ListNode head = new ListNode(2);
        ListNode next = new ListNode(1);
        // ListNode next2 = new ListNode(1);
        head.next = next;
        // head.next.next = next2;
        ListNode newHead = A.removeElements(head, 1);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
