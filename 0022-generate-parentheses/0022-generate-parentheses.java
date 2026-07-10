class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        helper(result,"",0,0,n);
        return result;
    }
    public void helper(List<String> result,String cur,int open,int close,int n){
        if(cur.length()==2*n){
            result.add(cur);
            return;
        }
        if(open<n){
            helper(result,cur+"(",open+1,close,n);
        }
        if(close<open){
            helper(result,cur+")",open,close+1,n);
        }
    }
}