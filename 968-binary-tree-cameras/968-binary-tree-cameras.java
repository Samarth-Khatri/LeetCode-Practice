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
    int cameras = 0;
    // 0 -> camera , 1 -> covered , -1 -> need camera/to be covered
    public int minCameraCover(TreeNode root) {
        if(minCameraCover_(root)==-1)
            cameras++;
        return cameras;
    }
    
    public int minCameraCover_(TreeNode root) {
        if(root==null)
            return 1;
        int lchild = minCameraCover_(root.left);
        int rchild = minCameraCover_(root.right);
        
        if(lchild==-1 || rchild==-1) {
            cameras++;
            return 0;
        }
        
        if(lchild==0 || rchild==0)
            return 1;
        
        return -1;
    }
}