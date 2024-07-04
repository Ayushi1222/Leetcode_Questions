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
class Solution {
    public ListNode mergeNodes(ListNode head) {
         ListNode prev = null;
        ListNode curr = head;

        while(curr.next != null){
            if(curr.next.val != 0){
                curr.val += curr.next.val;
                curr.next = curr.next.next;
            }
            else{
                prev = curr;
                curr =  curr.next;
            }
        }

        prev.next = null;
        return head;
    }
}