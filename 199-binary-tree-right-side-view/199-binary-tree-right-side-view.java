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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rres(root,list,0);
        return list;
    }
    
    public void rres(TreeNode node, List<Integer> list, int depth) {
        if(node!=null) {
            if(depth==list.size())
                list.add(node.val);
            rres(node.right,list,depth+1);
            rres(node.left,list,depth+1);
        }
    }
}