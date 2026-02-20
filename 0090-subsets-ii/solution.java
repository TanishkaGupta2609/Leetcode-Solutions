class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] nums,int idx,List<Integer> current,List<List<Integer>> ans){
       
            ans.add(new ArrayList<>(current));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])continue;
            current.add(nums[i]);
            helper(nums,i+1,current,ans);
            current.remove(current.size()-1);
      
        }
    }
}
