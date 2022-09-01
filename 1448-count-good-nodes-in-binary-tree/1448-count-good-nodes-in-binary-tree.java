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
    int cnt = 0;

    public int goodNodes(TreeNode root) {
        rres(root, root.val);
        return cnt;
    }

    private void rres(TreeNode node, int value) {
        if (node == null) 
            return; 
        if (node.val >= value) 
            cnt++;
        rres(node.left, Math.max(node.val, value));
        rres(node.right, Math.max(node.val, value));
    }
}
