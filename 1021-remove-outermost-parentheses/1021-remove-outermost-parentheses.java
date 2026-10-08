class Solution {
    public String removeOuterParentheses(String s) {
        String ans="";
        int cnt=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                if(cnt>0){
                    ans+="(";
                }
                cnt++;
            }else{
                    cnt--;
                    if(cnt>0)ans+=")";
                }
        }
        return ans;
    }
}