class Solution {
    int MOD = 1_000_000_007;

    long fastpower(long x, long y) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % MOD;
            x = (x * x) % MOD;
            y /= 2;
        }
        return res;
    }

    public int[] getFinalState(int[] nums, int k, int m) {

        if(m==1) return nums;
        int n=nums.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
            (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0] - b[0]
        );
        long max=0;
        for(int i=0;i<n;i++)
        {
            minHeap.add(new int[]{nums[i],i});
            max=Math.max(nums[i],max);
        }

        //iterating point, ki kaha par wo cross kar gya max element ko..
        while(k>0 && max / minHeap.peek()[0] >= m)
        {
            int[] min=minHeap.poll();
            min[0]=min[0]*m;
            minHeap.add(min);
            k--;
        }

        int times=k/n;
        int rem=k%n;

        // power krke value nikalo
        //simple wale jinka rem is 0

        long first= fastpower(m,times);
        //remainder bach jayega uske liye to extra ek baar multiply krna pdega...
        long second= fastpower(m,times+1);

        while(!minHeap.isEmpty())
        {
            int[] min=minHeap.poll();
            long multi= rem-->0 ? second : first;
            long val= (min[0]*multi) % MOD;
            nums[min[1]]=(int) val;
        }
        return nums;
    }
}