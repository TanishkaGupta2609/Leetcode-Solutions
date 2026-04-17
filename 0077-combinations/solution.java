class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        helper(ans,cur,n,k,1);
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> cur,int n,int k,int idx){
        if(cur.size()==k){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=idx;i<=n-(k-cur.size())+1;i++){
            cur.add(i);
            helper(ans,cur,n,k,i+1);
            cur.remove(cur.size()-1);
        }
    }
}
