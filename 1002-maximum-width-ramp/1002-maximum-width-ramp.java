class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(st.isEmpty() || nums[i]<nums[st.peek()])
            st.push(i);
        }
        int maxwidth=0;
        int j=n-1;
        while (j>=0)
        {
            while(!st.isEmpty() && nums[j]>=nums[st.peek()])
            {
                maxwidth=Math.max(maxwidth,j-st.peek());
                st.pop();
            }
            j--;
        }
        return maxwidth;
    }
}