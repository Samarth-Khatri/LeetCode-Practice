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

// Method 1
class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) 
            return true;
        if (root.val <= min || root.val >= max) 
            return false;
        return (isValid(root.left, min, root.val) && isValid(root.right, root.val, max));
    }
}

// class Solution {
//     private class BSTtriplet {
//         int max = Integer.MIN_VALUE;
//         int min = Integer.MAX_VALUE;
//         boolean isBST = true;
//     }
//     public boolean isValidBST(TreeNode root) {
//         if(root == null)
//             return true;
//         return bst(root).isBST;
//     }
//     public BSTtriplet bst(TreeNode node) {
//         if (node == null)  // base case
//             return new BSTtriplet();
//         BSTtriplet lt = bst(node.left); // left triplet
//         BSTtriplet rt = bst(node.right); // right triplet
//         BSTtriplet anst = new BSTtriplet(); // ans triplet
//         anst.min = Math.min(node.val, Math.min(lt.min, rt.min)); // getting min
//         anst.max = Math.max(node.val, Math.max(lt.max, rt.max)); // getting max
//         // if left triplet, right triplet is bst and node also follows bst condition then tree is bst
//         anst.isBST = lt.isBST && rt.isBST && node.val > lt.max && node.val < rt.min;
//         return anst;
//     }
// }
