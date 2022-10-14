/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode currPointer = mid(head);
        ListNode nextPointer = currPointer.next;
        if(currPointer.next != null) {
            currPointer.val = nextPointer.val;
            currPointer.next = nextPointer.next;
        } else head.next = null;
        return head; 
    }

    public ListNode mid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
