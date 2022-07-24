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

    public boolean findTarget(TreeNode root, int k) {
        return find(root, root, k);
    }

    private boolean findComplement(TreeNode root, int complement) {
        if (root == null) 
            return false;
        if (root.val == complement) 
            return true;

        return complement > root.val ? findComplement(root.right, complement) : findComplement(root.left, complement);
    }

    private boolean find(TreeNode parent, TreeNode root, int k) {
        if (root == null) 
            return false;

        boolean res = k - root.val != root.val ? findComplement(parent, k - root.val) : false;
        if (res) 
            return res;
        if (root.val < k) 
            res |= find(parent, root.right, k);

        return res | find(parent, root.left, k);
    }
}
