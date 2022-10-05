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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode new_root = new TreeNode(val);
            new_root.left = root;
            return new_root;
        }

        solve(root, val, 1, depth);
        return root;
    }

    private void solve(TreeNode root, int val, int curr_depth, int depth) {
        if (curr_depth == depth - 1) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
            return;
        }

        if (root.left != null) 
            solve(root.left, val, curr_depth + 1, depth);
        if (root.right != null) 
            solve(root.right, val, curr_depth + 1, depth);
    }
}