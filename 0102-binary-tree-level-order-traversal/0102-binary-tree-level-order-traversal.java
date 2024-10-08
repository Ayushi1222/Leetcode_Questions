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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>(); // ArrayDeque in place of LinkedList
        if(root==null) return ans;
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> l=new ArrayList<>(size);
            for(int i=0;i<size;i++)
            {
                TreeNode rv=q.poll();
                l.add(rv.val);
                if(rv.left!=null)
                    q.add(rv.left);
                if(rv.right!=null)
                    q.add(rv.right);
            }
            ans.add(l);
        }
        return ans;
    }
}