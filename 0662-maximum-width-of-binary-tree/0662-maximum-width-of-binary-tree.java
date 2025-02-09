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
    int maxWidth=0;
    public int widthOfBinaryTree(TreeNode root) {
        // DFS APPROACH
        if (root == null)
            return 0;
        dfs(root, 0, 0, new ArrayList<>());

        return maxWidth;
    }

    private void dfs(TreeNode node, int level, int index, ArrayList<Integer> l) {
        if (node == null)
            return;

        if (level == l.size()) {
            l.add(index);
        } 

        maxWidth = Math.max(maxWidth, index - l.get(level) + 1);

        dfs(node.left, level + 1, 2 * (index - l.get(level)) + 1, l);
        dfs(node.right, level + 1, 2 * (index  - l.get(level)) + 2, l);

    }
}