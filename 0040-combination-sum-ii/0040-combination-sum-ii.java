class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,target,candidates,cur,ans);
        return ans;
    }
    public void helper(int idx,int t,int[] nums,List<Integer> cur,List<List<Integer>> ans){
        if(t==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])continue;
            if(nums[i]>t)break;
            cur.add(nums[i]);
        helper(i+1,t-nums[i],nums,cur,ans);
        cur.remove(cur.size()-1);
        }

    }
    
}