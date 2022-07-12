/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        traverse(list,root);
        return list;
    }
    
    public void traverse(List<Integer> list, Node root) {
        if(root==null)
            return;
        for(Node child : root.children)
            traverse(list,child);
        list.add(root.val); 
    }
}