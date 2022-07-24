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

    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) // base case
            return null;

        if (node.val > key) 
            node.left = deleteNode(node.left, key); // left call bst condition
        
        else if (node.val < key)  
            node.right = deleteNode(node.right, key); // right call bst condition
        
        else {
            
            if (node.left != null && node.right != null) { // both child present
                int lmax = max(node.left);                 // find max from left
                node.val = lmax;                           // replace data of node with max
                node.left = deleteNode(node.left, lmax);   // remove max
                return node;
            } 
            
            else if (node.left != null) // remove when only left child present
                return node.left; 
            
            else if (node.right != null) // remove when only right child present
                return node.right; 
            
            else 
                return null; // leaf remove
        }

        return node;
    }

    public int max(TreeNode node) { // returns max
        if(node.right != null) 
            return max(node.right);
        
        else
            return node.val;
    }
}
