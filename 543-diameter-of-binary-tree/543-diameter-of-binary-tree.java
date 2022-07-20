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
    int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return dia;
    }

    public int diameter(TreeNode node) {
        if (node == null) 
            return -1;

        int lh = diameter(node.left);
        int rh = diameter(node.right);
        int ht = Math.max(lh, rh) + 1;

        if (lh + rh + 2 > dia) 
            dia = lh + rh + 2;

        return ht;
    }
}
