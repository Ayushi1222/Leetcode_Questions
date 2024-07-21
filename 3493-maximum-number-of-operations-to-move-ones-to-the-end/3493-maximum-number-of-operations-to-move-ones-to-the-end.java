class Solution {
    public int maxOperations(String s) {
        int n = s.length();
			int eo = 0;
			int ans = 0;
			for(int i = n-1;i >= 0;i--)
            {
				if(s.charAt(i) == '1' && (i+1 < n && s.charAt(i+1) == '0'))
                {
					eo++;
				}
				if(s.charAt(i) == '1'){
					ans += eo;
				}
			}
			return ans;
    }
}