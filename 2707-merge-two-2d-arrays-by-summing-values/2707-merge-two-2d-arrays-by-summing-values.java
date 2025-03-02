class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<int[]> l=new ArrayList<>();
        for(int[] n1:nums1)
        {
            if(map.containsKey(n1[0]))
            {
                map.put(n1[0],map.get(n1[0])+n1[1]);
            }
            else
            {
                map.put(n1[0],n1[1]);
            }
        }
        for(int[] n2:nums2)
        {
            if(map.containsKey(n2[0]))
            {
                map.put(n2[0],map.get(n2[0])+n2[1]);
            }
            else
            {
                map.put(n2[0],n2[1]);
            }
        }

        for(int key:map.keySet())
        {
            int[] arr=new int[]{key,map.get(key)};
            l.add(arr);
        }
        l.sort(Comparator.comparingInt(a->a[0]));
        return l.toArray(new int[l.size()][2]);
    }
}