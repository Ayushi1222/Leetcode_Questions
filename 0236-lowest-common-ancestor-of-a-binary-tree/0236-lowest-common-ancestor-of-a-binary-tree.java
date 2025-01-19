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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q)
        {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        // Both sides true -- root is LCA
        if(left!=null && right!=null)
        return root;
        // right null-- left contains 
        else if(left!=null && right==null) 
        return left;
        // left null -- right contains
        else if(left==null && right!=null)
        return right;
        // None contains -- null
        else
        return null;
    }
}