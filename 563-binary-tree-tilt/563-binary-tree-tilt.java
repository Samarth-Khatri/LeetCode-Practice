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
    int tilt = 0;

    public int findTilt(TreeNode root) {
        tilt(root);
        return tilt;
    }

    private int tilt(TreeNode node) {
        if (node == null) return 0;
        int ls = tilt(node.left); // left sum
        int rs = tilt(node.right); // right sum
        tilt += Math.abs(ls - rs); // tilt for a particular node
        return node.val + ls + rs; // total sum
    }
}
