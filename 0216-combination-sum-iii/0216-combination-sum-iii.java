class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        helper(k,n,1,cur,ans);
        return ans;
    }
    public void helper(int k,int n,int idx,List<Integer> cur,List<List<Integer>> ans){
        if(k==0 && n==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(n<0)return;
        for(int i=idx;i<=9;i++){
            cur.add(i);
            helper(k-1,n-i,i+1,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}