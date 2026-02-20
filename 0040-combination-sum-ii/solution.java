class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] nums,int idx,int k,List<Integer> current,List<List<Integer>> ans){
        
            if(k==0){
                ans.add(new ArrayList<>(current));
            }
        
       
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])continue;
            if(nums[i]>k)break;

            current.add(nums[i]);
        helper(nums,i+1,k-nums[i],current,ans);
        current.remove(current.size()-1);
        
        }
        
    }
}
