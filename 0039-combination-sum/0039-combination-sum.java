class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        helper(ans,cur,candidates,target,0);
        return ans;
        
    }
    public void helper(List<List<Integer>> ans,List<Integer> cur,int[] nums,int t,int idx){
        if(t<0 || idx==nums.length)return;
            if(t==0){
                ans.add(new ArrayList<>(cur));
                return;
            }
        
        cur.add(nums[idx]);
        helper(ans,cur,nums,t-nums[idx],idx);
        cur.remove(cur.size()-1);
        helper(ans,cur,nums,t,idx+1);
    }
}