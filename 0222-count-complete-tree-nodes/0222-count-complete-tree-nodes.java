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
    private int c=0;
    public int countNodes(TreeNode root) {
        return count(root);
    }

    private int count(TreeNode root)
    {
        if(root==null) return 0;
        int l=count(root.left);
        int r=count(root.right);
        return l+r+1;
    }
}