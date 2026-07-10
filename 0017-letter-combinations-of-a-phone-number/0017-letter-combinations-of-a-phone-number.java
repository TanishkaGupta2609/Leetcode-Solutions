class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(ans,new StringBuilder(),digits,map,0);
        return ans;
    }
    public void helper(List<String> ans,StringBuilder cur,String digits,String[] map,int idx){
        if(idx==digits.length()){
            ans.add(cur.toString());
            return;
        }
        String letter=map[digits.charAt(idx)-'0'];
        for(int i=0;i<letter.length();i++){
            char ch=letter.charAt(i);
            cur.append(ch);
            helper(ans,cur,digits,map,idx+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}