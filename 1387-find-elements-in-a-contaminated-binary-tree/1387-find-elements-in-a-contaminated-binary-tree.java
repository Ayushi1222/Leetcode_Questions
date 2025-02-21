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
class FindElements {
    private TreeNode root;
    private void recover(TreeNode root, int val)
    {
        if(root==null) return;
        root.val=val;
        recover(root.left,2*val+1);
        recover(root.right,2*val+2);
    }

    public FindElements(TreeNode root) {
        this.root=root;
        recover(root,0);
    }
    
    public boolean find(int target) {
        return findTarget(root, target);
    }
    private boolean findTarget(TreeNode root,int target)
    {
        if(root==null) return false;
        if(root.val==target) return true;
        boolean left=findTarget(root.left,target);
        boolean right=findTarget(root.right,target);
        return left || right;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */