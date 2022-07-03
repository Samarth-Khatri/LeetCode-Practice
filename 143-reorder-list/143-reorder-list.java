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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode mid = middleNode(head); // find mid
        ListNode nHead = mid.next; // create head for second list
        mid.next = null; // detach two list
        
        nHead = reverseList(nHead); // reverse second list
        
        ListNode c1=head, c2=nHead; // Now add two list together
        while(c2!=null) {
            ListNode f1=c1.next, f2=c2.next; // backup
            c1.next = c2; // linkup
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
    }
    
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
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
    
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}