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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode left=head;
        ListNode right = left.next;
        while(right!=null)
        {
            int gcdValue = calculateGCD(left.val, right.val);
            ListNode gcdNode = new ListNode(gcdValue);

            left.next = gcdNode;
            gcdNode.next = right;
            left = right;
            right = right.next;
        }
        return head;
    }
    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}