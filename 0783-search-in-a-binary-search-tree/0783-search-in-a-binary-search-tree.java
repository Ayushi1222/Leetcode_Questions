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
    public TreeNode searchBST(TreeNode root, int t) {
        return search(root,t);
    }

    private TreeNode search(TreeNode node, int t)
    {
        if(node==null) return null;
        if(node.val==t) 
        {
            return node;
        }
        else if(t<node.val)
        {
            return search(node.left,t);
        }
        else
        {
            return search(node.right,t);
        }
    }
}