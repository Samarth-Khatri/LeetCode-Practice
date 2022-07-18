/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> n2rpath = nodeToRootPath(root, target.val);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n2rpath.size(); ++i) 
            ans.addAll(KLevelsDown(n2rpath.get(i), k - i, i > 0 ? n2rpath.get(i - 1) : null));
        return ans;
    }

    public List<TreeNode> nodeToRootPath(TreeNode node, int data) {
        if (node == null) 
            return new ArrayList<>();

        if (node.val == data) {
            List<TreeNode> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        List<TreeNode> llist = nodeToRootPath(node.left, data);
        if (llist.size() > 0) {
            llist.add(node);
            return llist;
        }

        List<TreeNode> rlist = nodeToRootPath(node.right, data);
        if (rlist.size() > 0) {
            rlist.add(node);
            return rlist;
        }

        return new ArrayList<>();
    }

    public List<Integer> KLevelsDown(TreeNode root, int k, TreeNode blocker){
        if(root == null || k <0 || root == blocker) {
            List<Integer> list = new ArrayList<>();
            return list;
        }
        else if(k == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            return list;
        }

        List<Integer> list1 = KLevelsDown(root.left, k-1, blocker);
        List<Integer> list2 = KLevelsDown(root.right, k-1, blocker);
        
        list1.addAll(list2);
        
        return list1;
    }
}
