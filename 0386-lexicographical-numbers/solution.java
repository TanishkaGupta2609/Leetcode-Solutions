class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans=new ArrayList<>();
        helper(n,1,ans);
        return ans;
    }
    public void helper(int n,int cur,List<Integer> ans){
        if(cur>n)return;
        ans.add(cur);
        helper(n,cur*10,ans);
        if(cur%10!=9){
            helper(n,cur+1,ans);
        }
        
    }
}
