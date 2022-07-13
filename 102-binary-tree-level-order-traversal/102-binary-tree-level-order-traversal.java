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
    public List<List<Integer>> levelOrder(TreeNode root) {
         if(root == null)
            return new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        que.addLast(root);

        while(que.size()!=0) {
            int currSize = que.size();
            List<Integer> tempList = new ArrayList<>();
            while(currSize-->0) {
                TreeNode temp = que.removeFirst();
                if(temp.left != null)
                    que.addLast(temp.left);
                if(temp.right != null)
                    que.addLast(temp.right);
                tempList.add(temp.val);
            }   
            list.add(tempList);
        }
        return list;
    }
}