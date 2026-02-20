class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> result=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,target,0,result,ans);
        return ans;
    }
    public void helper(int[] nums,int target,int idx,List<Integer> result,List<List<Integer>> ans){
       
        if(idx==nums.length){
            if(target==0){
             ans.add(new ArrayList<>(result));
            }
        }
        if(idx==nums.length || target<0)return;
        result.add(nums[idx]);
        helper(nums,target-nums[idx],idx,result,ans);
        result.remove(result.size()-1);
        helper(nums,target,idx+1,result,ans);
    }
}
