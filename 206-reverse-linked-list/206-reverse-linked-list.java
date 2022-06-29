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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // first pointer
        ListNode curr = head; // second pointer
        while(curr!=null) {
            ListNode next = curr.next; // third pointer
            curr.next = prev; // reversing the pointer
            prev = curr;  
            curr = next;  // moving forward using next
        }
        return prev;
    }
}