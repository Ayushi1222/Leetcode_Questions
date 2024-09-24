class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        String[] arr1Strs = Arrays.stream(arr1).mapToObj(String::valueOf).toArray(String[]::new);
        String[] arr2Strs = Arrays.stream(arr2).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr2Strs);

        int longestPrefix = 0;
        for (String s1 : arr1Strs) 
        {
            int low = 0, high = arr2Strs.length - 1;
            while (low <= high) 
            {
                int mid = low + (high - low) / 2;
                if (arr2Strs[mid].startsWith(s1)) 
                {
                    longestPrefix = Math.max(longestPrefix, s1.length());
                    break; // Found a match, no need to search further
                } 
                else if (arr2Strs[mid].compareTo(s1) < 0) 
                {
                    low = mid + 1;
                } 
                else 
                {
                    high = mid - 1;
                }
            }

            // If exact prefix match is not found, check the longest prefix with neighbors
            if (low < arr2Strs.length) 
            {
                longestPrefix = Math.max(longestPrefix, commonPrefixLength(s1, arr2Strs[low]));
            }
            if (high >= 0) 
            {
                longestPrefix = Math.max(longestPrefix, commonPrefixLength(s1, arr2Strs[high]));
            }
        }

        return longestPrefix;
    }
    
    private int commonPrefixLength(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < minLength && str1.charAt(i) == str2.charAt(i)) 
        {
            i++;
        }
        return i;
    }
}