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
    private int moves=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode curr)
    {
        if(curr==null) return 0;
        int leftCoins=dfs(curr.left);
        int rightCoins=dfs(curr.right);

        moves+=Math.abs(leftCoins)+Math.abs(rightCoins);

        return (curr.val-1) + leftCoins + rightCoins;
    }
}