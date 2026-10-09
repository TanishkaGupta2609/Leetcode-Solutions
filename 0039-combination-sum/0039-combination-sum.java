class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        helper(0,candidates,target,cur,ans);
        return ans;
    }
    public void helper(int idx,int[] nums,int t,List<Integer> cur,List<List<Integer>> ans){
        if(t<0 || idx==nums.length)return;
            if(t==0){
                ans.add(new ArrayList<>(cur));
                return;
            }
        cur.add(nums[idx]);
        helper(idx,nums,t-nums[idx],cur,ans);
        cur.remove(cur.size()-1);
        helper(idx+1,nums,t,cur,ans);
    }
}