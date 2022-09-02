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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) 
            return res;
        rres(root, res);
        return res;
    }

    private void rres(TreeNode root, List<Double> ans) {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            int elements = n;
            double sum = 0;
            while (n-->0) {
                TreeNode node = que.poll();
                sum += node.val;
                if (node.left != null) 
                    que.add(node.left);
                if (node.right != null) 
                    que.add(node.right);
            }

            ans.add(sum / elements);
        }
    }
}
