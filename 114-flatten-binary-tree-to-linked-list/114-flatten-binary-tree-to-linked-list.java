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
    // Same as Linearize a GT into LinkedList
    public void flatten(TreeNode root) {
        if (root == null) // base case 
            return;
        
        flatten(root.left); // flat the left by recursion
        flatten(root.right); // flat the right by recursion

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left; // treat left tree as right tree

        TreeNode p = root;
        while (p.right != null)  //put the old right tree on the end of left tree
            p = p.right;

        p.right = right;
    }
}
