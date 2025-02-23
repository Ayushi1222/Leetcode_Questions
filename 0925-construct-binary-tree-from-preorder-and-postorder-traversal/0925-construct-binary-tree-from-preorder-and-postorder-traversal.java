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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        return constructTree(0,n-1,0, preorder, postorder);
    }
    private TreeNode constructTree(int preStart, int preEnd, int postStart, int[] pre, int[] post)
    {
        // Base case: If there are no nodes to process, return null
        if (preStart > preEnd) return null;
        // Base case: If only one node is left, return that node
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }

        int leftRoot=pre[preStart+1];
        int noOfLeftNodes=1;
        while(post[postStart+ noOfLeftNodes-1]!=leftRoot)
        {
            noOfLeftNodes++;
        }

        TreeNode root = new TreeNode(pre[preStart]);

        root.left=constructTree(preStart+1, preStart+noOfLeftNodes, postStart, pre, post);
        root.right=constructTree(preStart+noOfLeftNodes+1, preEnd, postStart+ noOfLeftNodes, pre, post);

        return root;
    }
}