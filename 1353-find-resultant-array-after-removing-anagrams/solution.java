class Solution {
    public List<String> removeAnagrams(String[] words) {
       String prev="";
       List<String> ans=new ArrayList<>();
        for(String c: words){
            char[] str=c.toCharArray();
            Arrays.sort(str);
            String key=new String(str);
            if(!key.equals(prev)){
                ans.add(c);
                prev=key;
            }
        }
        
        
        return ans;
    }
}
