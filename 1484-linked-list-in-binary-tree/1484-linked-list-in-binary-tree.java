/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        return trackPath(head,head,root);
    }
    private boolean trackPath(ListNode head, ListNode temp,TreeNode root){
        if(temp==null) return true;
        if(root==null) return false;
        //curr node match kre...
        if(root.val==temp.val)
            temp=temp.next;
        //curr node match na kre but head match kiya tha
        else if(root.val==head.val)
        head=head.next;
        //koi match na kre to reset krdo
        else temp=head;
        return trackPath(head,temp,root.left) || trackPath(head,temp,root.right);
    }
}