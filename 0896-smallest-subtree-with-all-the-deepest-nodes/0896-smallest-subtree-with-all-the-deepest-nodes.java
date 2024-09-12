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
    private int deepest = 0;
    private TreeNode node;

    public TreeNode subtreeWithAllDeepest(final TreeNode root) {
        helper(root, 0);
        return node;
    }

    private int helper(final TreeNode root, final int depth) {
        this.deepest = Math.max(this.deepest, depth);

        if(root == null)
            return depth;

        final int l = helper(root.left, depth + 1), r = helper(root.right, depth + 1);

        if(l == this.deepest && l == r)
            this.node = root;

        return Math.max(l, r);
    }
}