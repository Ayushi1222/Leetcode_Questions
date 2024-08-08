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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> l =new ArrayList<>();
        calculate(root,targetSum,ans,l);
        return ans;
    }
    private void calculate(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer> l)
    {
        if(root==null) return;
        l.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(targetSum-root.val==0)
            {
                ans.add(new ArrayList<>(l));
            }
        }
        calculate(root.left,targetSum-root.val,ans,l);
        calculate(root.right,targetSum-root.val,ans,l);
        l.remove(l.size()-1);
    }
}