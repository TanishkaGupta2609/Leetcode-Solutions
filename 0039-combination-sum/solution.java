class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        helper(candidates,target,0,cur,ans);
        return ans;
    }
    public void helper(int[] nums,int t,int idx,List<Integer> cur,List<List<Integer>> ans){
            if(t==0){
                ans.add(new ArrayList<>(cur));
                return;
            }
        if(t<0)return;
        for(int i=idx;i<nums.length;i++){
            cur.add(nums[i]);
            helper(nums,t-nums[i],i,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}
