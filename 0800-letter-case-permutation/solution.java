class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        helper(s,0,new StringBuilder(),ans);
        return ans;
    }
    public void helper(String s,int idx,StringBuilder cur,List<String> ans){
        if(idx==s.length()){
            ans.add(cur.toString());
            return;
        }
            char ch=s.charAt(idx);
            if(Character.isLetter(ch)){
                cur.append(Character.toLowerCase(ch));
                helper(s,idx+1,cur,ans);
                cur.deleteCharAt(cur.length()-1);

                cur.append(Character.toUpperCase(ch));
                helper(s,idx+1,cur,ans);
                cur.deleteCharAt(cur.length()-1);
            }
            else{
                cur.append(ch);
                helper(s,idx+1,cur,ans);
                cur.deleteCharAt(cur.length()-1);
            }
        
    }
}
