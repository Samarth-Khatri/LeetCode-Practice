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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        
        int i=1;
        for (;i<left;++i) {
            prev = curr;
            curr = curr.next;
        }
 
        ListNode start = curr;
        ListNode end = null;
 
        for (;i<=right;++i) {
            ListNode next = curr.next;
            curr.next = end;
            end = curr;
            curr = next;
        }

        start.next = curr;
        if (prev!=null) 
            prev.next = end;
        else 
            head = end;     
        
        return head;
    }
}