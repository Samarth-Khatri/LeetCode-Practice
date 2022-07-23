/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;

    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) 
            return 0;
        if (node.val < low && node.val < high) 
            rangeSumBST(node.right, low, high); 
        else if (node.val > low && node.val > high) 
            rangeSumBST(node.left, low, high); 
        else {
            rangeSumBST(node.left, low, high);
            sum += node.val;
            rangeSumBST(node.right, low, high);
        }
        
        return sum;
    }
}
