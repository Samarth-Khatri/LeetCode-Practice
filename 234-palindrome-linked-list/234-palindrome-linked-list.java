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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode reverse = reverseList(mid); //reverse ListNode starting from middle
        while(reverse!=null) {
            if(reverse.val != head.val) 
                return false;
            reverse = reverse.next;
            head = head.next;
        }
        return true;    
    }
    
    //Reverse ListNode
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
    
    //Find middle of ListNode
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}