class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(n,k,1,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int n,int k,int idx,List<Integer> cur,List<List<Integer>> ans){
        if(cur.size()==k){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=idx;i<=n-(k-cur.size())+1;i++){
            cur.add(i);
            helper(n,k,i+1,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}
