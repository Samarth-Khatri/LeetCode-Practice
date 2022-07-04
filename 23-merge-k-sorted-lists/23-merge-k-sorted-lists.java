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
    
    // Approac 1 -> Bakwas Approach - Slow
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists.length==0) 
    //         return null;
    //     ListNode ans = null; // new list 
    //     for(ListNode head:lists) // iterating through list array
    //         ans = mergeTwoLists(ans,head); // merging ans list and next list in array
    //     return ans;
    // }
    
    
    // Approach 2 -> Divide and Conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) 
            return null;
        return mergeKL(lists,0,lists.length-1);
    }
    
    public ListNode mergeKL(ListNode[] lists, int si, int ei) {
        if(si==ei)
            return lists[si];
        int mid = (si+ei)/2;
        ListNode l1 = mergeKL(lists,si,mid);
        ListNode l2 = mergeKL(lists,mid+1,ei);
        return mergeTwoLists(l1,l2);
    }
    
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