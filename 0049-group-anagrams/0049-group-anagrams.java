class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> table = new HashMap<>();
        for(String str : strs){
            String key = generateKey(str);
            if(table.containsKey(key)){
                table.get(key).add(str);
            }else{
                List list = new ArrayList<>();
                list.add(str);
                table.put(key, list);
            }
        }

        return new ArrayList<>(table.values());
        
    }

    private String generateKey(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
        
}