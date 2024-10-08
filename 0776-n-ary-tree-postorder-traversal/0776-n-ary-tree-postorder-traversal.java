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
        List<Integer> l=new ArrayList<>();
        if(root==null) return l;
        post(root,l);
        return l;
    }

    private void post(Node node,List<Integer> l)
    {
        for(Node child : node.children)
        {
            if(child!=null)
            post(child,l);
        }
        l.add(node.val);
    }
}