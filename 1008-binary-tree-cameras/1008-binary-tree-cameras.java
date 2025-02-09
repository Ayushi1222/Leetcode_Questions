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

    // For this question we start with states:
    // State 0--> covered, with a camera
    // State 1--> covered, without a camera
    // State 2--> not covered in any way.
    // So if the state is 2 we increase the camera count.
    int camera=0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==2) // if root is left by chance then we cover it
        camera++;
        return camera;
    }

    private int dfs(TreeNode node)
    {
        if(node==null) //NULL nodes are already covered
        return 1;

        int left=dfs(node.left);
        int right=dfs(node.right);

        // If none of the child is covered.
        // if the state of left or right are 2, place a camera and state is now 0 
        if(left==2 || right==2)
        {
            camera++;
            return 0;
        }
        // If any of the child has camera,
        // the node is covered and with a camera, return state 1. 
        if(left==0 || right==0)
        {
            return 1;
        }

        // If children are covered but do not have cameras, there should be camera.
        // else, not covered return state 2.
        return 2;
    }
}