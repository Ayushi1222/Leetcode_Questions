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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode temp=head;
        int[][] ans = new int[m][n];
        int minc=0;
        int minr=0;
        int maxc=n-1;
        int maxr=m-1;
        int te=m*n;
        int c=0;
        while(c<te)
        {
            for (int i = minc; i <= maxc && c<te; i++) {
                if(temp!=null)
                {
                    ans[minr][i]=temp.val;
                    temp=temp.next;
                }
                else 
                ans[minr][i]=-1;
                c++;
            }
            minr++;
            for (int i = minr; i <= maxr&& c<te; i++) {
                if(temp!=null)
                {
                    ans[i][maxc]=temp.val;
                    temp=temp.next;
                }
                else 
                ans[i][maxc]=-1;
                c++;
            }
            maxc--;
            for (int i = maxc; i >= minc&& c<te; i--) {
                if(temp!=null)
                {
                    ans[maxr][i]=temp.val;
                    temp=temp.next;
                }
                else 
                ans[maxr][i]=-1;
                c++;
            }
            maxr--;
            for (int i = maxr; i >= minr&& c<te; i--) {
                if(temp!=null)
                {
                    ans[i][minc]=temp.val;
                    temp=temp.next;
                }
                else 
                ans[i][minc]=-1;
                c++;
            }
            minc++;
        }
        return ans;
    }
}