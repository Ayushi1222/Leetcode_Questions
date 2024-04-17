class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int t=m+n;
        if(m>n) return findMedianSortedArrays(nums2,nums1);
        int s=0;
        int e=m;
        int left=(n+m+1)/2;
        while(s<=e)
        {
            int mid1=(s+e)/2;
            int mid2=left-mid1;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) 
            {
                if (t % 2 == 1) 
                return Math.max(l1, l2);
                else 
                return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } 
            else if (l1 > r2) 
            e = mid1 - 1;
            else 
            s = mid1 + 1;
        }
        return 0;
    }
}