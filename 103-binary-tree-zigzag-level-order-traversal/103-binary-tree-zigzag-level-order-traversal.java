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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftToRight = true;
        while(queue.size()>0) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>(size);
            for(int i=0;i<size;++i) {
                TreeNode node = queue.poll();
                //level order traversal
                if(isLeftToRight)
                    temp.add(node.val);
                else 
                //reverse order traversal
                    temp.add(0,node.val);
            
                if(node.left != null )
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.add(temp);
            isLeftToRight = !isLeftToRight;
        }
        return result;
    }
}
