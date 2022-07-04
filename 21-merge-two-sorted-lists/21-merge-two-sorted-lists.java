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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null || list2==null) // null condition check
            return list1!=null ? list1 : list2;
        
        ListNode c1 = list1, c2 = list2, dummy = new ListNode(-1), prev = dummy;
        
        while(c1!=null && c2!=null) { // until 1 list is null
            if(c1.val<c2.val) { // attach c1 if c1 is less
                prev.next = c1;
                c1 = c1.next;
            } 
            else {  // attach c2 if c2 is less
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next; // move prev to next
        }
        
        prev.next = (c1!=null ? c1 : c2); // attach prev to the list which is not null
        
        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }
}