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
    int target = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        if (root == null) 
            return false;
        return hasEqualSum(root, 0);
    }

    boolean hasEqualSum(TreeNode node, int sum) {
        if (node == null) 
            return false;
        sum += node.val;
        if (node.left == null && node.right == null) 
            return sum == target;
        else return hasEqualSum(node.left, sum) || hasEqualSum(node.right, sum);
    }
}
