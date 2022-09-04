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

    public class vPair {
        TreeNode node = null;
        int hl = 0;

        vPair(TreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    public static void width(TreeNode root, int hl, int[] arr) {
        if (root == null) 
            return;
        arr[0] = Math.min(arr[0], hl);
        arr[1] = Math.max(arr[1], hl);
        width(root.left, hl - 1, arr);
        width(root.right, hl + 1, arr);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //parent and child priority queue
        PriorityQueue<vPair> parQ = new PriorityQueue<>((a,b) -> {return a.node.val - b.node.val;} );
        PriorityQueue<vPair> chQ = new PriorityQueue<>((a,b) -> {return a.node.val - b.node.val;} );

        //width
        int[] arr = new int[2];
        width(root, 0, arr);
        int w = arr[1] - arr[0] + 1;

        //creating arraylist of given width size
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < w; ++i) 
            ans.add(new ArrayList());

        parQ.add(new vPair(root, Math.abs(arr[0])));
        
        while (!parQ.isEmpty()) {
            int size = parQ.size();

            while (size-- > 0) {
                vPair rp = parQ.remove();
                TreeNode node = rp.node;
                int hl = rp.hl;

                //setting answer in that horizontal level
                ans.get(hl).add(node.val);

                //adding childs in childQueue
                if (node.left != null) 
                    chQ.add(new vPair(node.left, hl - 1));

                if (node.right != null) 
                    chQ.add(new vPair(node.right, hl + 1));
            }
            
            //swapping the queues
            PriorityQueue<vPair> tempQ = parQ;
            parQ = chQ;
            chQ = tempQ;
        }

        return ans;
    }
}
