class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String c:strs){
            char[] arr=c.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(c);
        }
        return new ArrayList<>(map.values());
    }
}
