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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return rBuildTree(preorder,0,n-1,inorder,0,n-1);
    }
    
    // psi -> Preorder starting index
    // pei -> Preorder ending index
    // isi -> Ineorder starting index
    // iei -> Ineorder ending index
    // colse -> Count of Left Sub Tree elements
    private TreeNode rBuildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if(isi>iei)
            return null;
        int idx = isi;
        while(inorder[idx]!=preorder[psi])
            idx++;
        
        int colse = idx-isi;
        TreeNode node = new TreeNode(preorder[psi]);
        
        node.left = rBuildTree(preorder,psi+1,psi+colse,inorder,isi,idx-1); // left subtree call
        node.right = rBuildTree(preorder,psi+colse+1,pei,inorder,idx+1,iei); // right subtree call
            
        return node;
    }
}