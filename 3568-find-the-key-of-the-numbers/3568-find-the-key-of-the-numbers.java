class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String str1 = String.format("%04d", num1);
        String str2 = String.format("%04d", num2);
        String str3 = String.format("%04d", num3);
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 4; i++) 
        {
            char digit1 = str1.charAt(i);
            char digit2 = str2.charAt(i);
            char digit3 = str3.charAt(i);
            char minDigit = (char) Math.min(Math.min(digit1, digit2), digit3);
            key.append(minDigit);
        }
        int resultKey = Integer.parseInt(key.toString());
        return resultKey;
    }
}