class Solution {
    public String fractionToDecimal(int n, int d) {
        if(n==0) return "0";

        StringBuilder sb=new StringBuilder();
        sb.append(((n > 0) ^ (d > 0))? "-":"");

        long num=Math.abs((long)n);
        long den=Math.abs((long)d);

        sb.append(num/den);
        num%=den;
        if(num==0) return sb.toString();

        sb.append(".");
        HashMap<Long, Integer> map=new HashMap<>();
        while(num!=0)
        {
            num*=10;
            sb.append(num/den);
            num%=den;
            if(map.containsKey(num))
            {
                int index=map.get(num);
                sb.insert(index,"(");
                sb.append(")");
                break;
            }
            else
            {
                map.put(num,sb.length());
            }
        }
        return sb.toString();
    }
}