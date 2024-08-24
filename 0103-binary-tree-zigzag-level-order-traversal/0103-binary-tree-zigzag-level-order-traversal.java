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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root == null)
            return ans;

        deque.push(root);
        boolean flag=true;

        while(!deque.isEmpty())
        {
            int size=deque.size();
            List<Integer> l=new ArrayList<>(size);
            for(int i=0;i<size;i++)
            {
                TreeNode n=deque.poll();
                if(n.left!=null)
                deque.add(n.left);
                if(n.right!=null)
                deque.add(n.right);

                l.add(n.val);
            }
            if(!flag)
            {
                Collections.reverse(l);
            }
            flag=!flag;
            ans.add(l);
        }
        return ans;
    }
}