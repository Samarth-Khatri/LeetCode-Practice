/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public void deleteNode(ListNode node) {
        ListNode currentPointer = node;
        ListNode nextPointer = node.next;
        currentPointer.val = nextPointer.val;
        currentPointer.next = nextPointer.next;
    }
}
