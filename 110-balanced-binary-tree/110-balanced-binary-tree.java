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
    boolean isTreeBal = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        height(root);
        return isTreeBal;
    }

    private int height(TreeNode node) {
        if (node == null) 
            return 0;
        
        int lh = height(node.left); // left height
        int rh = height(node.right); // right height
        
        if (!(Math.abs(lh - rh) <= 1)) // balance condition check
            isTreeBal = false;
        
        return Math.max(lh, rh) + 1; // returning height
    }
}
