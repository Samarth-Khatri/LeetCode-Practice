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
    public ListNode partition(ListNode head, int x) {
        ListNode sm = new ListNode(); // < target
        ListNode lg = new ListNode(); // >= target
        ListNode smHead = sm, lgHead = lg;
        
        while(head!=null) {
            if(head.val<x) { // adding node to small
                smHead.next = head;
                smHead = smHead.next;
            }
            else { // adding node to large
                lgHead.next = head;
                lgHead = lgHead.next;    
            }
            head = head.next; // iterating through head
        }
        
        lgHead.next = null; // tail of linkedlist to null
        smHead.next = lg.next; // connecting two linkedlists
        
        return sm.next; 
    }
}