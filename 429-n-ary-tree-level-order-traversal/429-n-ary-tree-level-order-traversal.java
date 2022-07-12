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
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();
        LinkedList<Node> que = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        que.addLast(root);

        while(que.size()!=0) {
            int currSize = que.size();
            List<Integer> tempList = new ArrayList<>();
            while(currSize-->0) {
                Node temp = que.removeFirst();
                for(int i=0;i<temp.children.size();++i)
                    if(temp.children.get(i)!=null)
                        que.addLast(temp.children.get(i));
                tempList.add(temp.val);
            }   
            list.add(tempList);
        }
        return list;
    }
}