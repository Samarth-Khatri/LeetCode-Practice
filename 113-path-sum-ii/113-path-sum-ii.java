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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        getTargetSum(targetSum, 0, root, new ArrayList<>());
        return res;
    }

    private void getTargetSum(int target, int sum, TreeNode node, List<Integer> list) {
        if (node == null) 
            return;

        sum += node.val;
        list.add(node.val);

        if (node.left == null && node.right == null) {
            if (target == sum) 
                res.add(list);
            return;
        }

        getTargetSum(target, sum, node.left, new ArrayList<>(list));
        getTargetSum(target, sum, node.right, new ArrayList<>(list));
    }
}
