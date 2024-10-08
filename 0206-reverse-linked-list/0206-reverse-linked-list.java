/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode c = head; // current node
        ListNode p = null; // previous node
        ListNode n = null; // next node

        while (c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }

        return p;
    }
}