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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};

        ListNode left, mid, right;
        left = head;
        mid = left.next;
        right = mid.next;
        int index = 1;
        int minDist = Integer.MAX_VALUE;
        int prevIndex = -1;
        int firstIndex = -1;

        while (right != null) {

            right = mid.next;

            if((left.val < mid.val && mid.val > right.val)
                || (left.val > mid.val && mid.val < right.val)) {

                if(prevIndex != -1) {
                    minDist = Math.min(minDist, index - prevIndex);
                }
                if(firstIndex == -1) {
                    firstIndex = index; // 
                }
                prevIndex = index;
                // list.add(index);

            }
            left = mid;
            mid = right;
            right = right.next;
            index++;
        }

        if(firstIndex != prevIndex) {
            result[0] = minDist;
            result[1] = prevIndex - firstIndex;
        }

        return result;
    }
}