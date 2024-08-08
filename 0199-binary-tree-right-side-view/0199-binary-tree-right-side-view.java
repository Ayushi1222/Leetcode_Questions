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
    int max_level=0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        rightView(root,1,l);
        return l;
    }
    private void rightView(TreeNode root, int curr_level,List<Integer> l)
    {
        if(root==null) return;
        if(curr_level>max_level)
        {
            l.add(root.val);
            max_level=curr_level;
        }
        //pehle right ka call lgana hai becs=z we want right value....
        rightView(root.right,curr_level+1,l);
        rightView(root.left,curr_level+1,l);
    }

}