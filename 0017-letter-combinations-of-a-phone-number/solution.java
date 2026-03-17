class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits,0,new StringBuilder(),ans,map);
        return ans;
    }
    public void helper(String digits,int idx,StringBuilder cur,List<String> ans,String[] map){
        if(idx==digits.length()){
            ans.add(cur.toString());
            return;
        }
        String letters=map[digits.charAt(idx)-'0'];
        for(char ch:letters.toCharArray()){
            cur.append(ch);
            helper(digits,idx+1,cur,ans,map);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
