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
    
    // Left -> Root -> Right
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List node = new ArrayList();
    //     if (root != null) {
    //         node.addAll(inorderTraversal(root.left));
    //         node.add(root.val);
    //         node.addAll(inorderTraversal(root.right));
    //     }
    //     return node;
    // }
    
    public static TreeNode rightMostNode(TreeNode node, TreeNode curr) {
        while(node.right != null && node.right != curr) node = node.right;
        return node;
    }
    
    public List<Integer> inorderTraversal(TreeNode node) {
         List<Integer> ans = new ArrayList<>();
        TreeNode curr = node;
        while(curr != null) {
            TreeNode left = curr.left;
            if(left == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode rmn = rightMostNode(left, curr);
                if(rmn.right == null) {
                    rmn.right = curr;
                    curr = curr.left;
                }
                else {
                    rmn.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
