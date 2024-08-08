class Solution {
    private static String[] less_than_10={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private static String[] less_than_20={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private static String[] less_than_100={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num==0)
        return "Zero";
        return solve(num).trim();
    }
    private String solve(int num)
    {
        if(num<10)
        return less_than_10[num];

        if(num<20)
        return less_than_20[num%10];

        if(num<100) // 89/10
        return less_than_100[num/10] + ((num%10 != 0) ? " " + less_than_10[num%10] : "");

        if(num<1000) //549/100
        return less_than_10[num/100]+ " Hundred" + ((num%100 != 0) ? " " + solve(num%100) : "");

        if(num<1000000) //5496/1000
        return solve(num/1000)+" Thousand"+((num%1000 != 0) ? " " + solve(num%1000) : "");

        if(num<1000000000) //1234567/1000000
        return solve(num/1000000)+" Million"+ ((num%1000000 != 0) ? " " + solve(num%1000000) : "");

        return solve(num/1000000000) +" Billion"+ ((num%1000000000 != 0) ? " " + solve(num%1000000000) : "");
    }
}