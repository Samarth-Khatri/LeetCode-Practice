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

    public TreeNode searchBST(TreeNode node, int val) {
        if (node == null) return null;
        if (val == node.val) return node;
        return (val > node.val) ? searchBST(node.right, val) : searchBST(node.left, val);
    }
}
