class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stk = new Stack<>();
        int strLength = s.length();
        int partLength = part.length();
        for (int i = 0; i < strLength; i++) {
            stk.push(s.charAt(i));
            if (stk.size() >= partLength && checkMatch(stk, part, partLength)) {
                for (int j = 0; j < partLength; j++) {
                    stk.pop();
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        result.reverse();

        return result.toString();
    }
    private boolean checkMatch(Stack<Character> stk,String part,int partLength) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stk); 
        for (int i = partLength - 1; i >= 0; i--) 
        {
            if (temp.isEmpty() || temp.peek() != part.charAt(i)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}