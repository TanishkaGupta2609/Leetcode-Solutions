class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,0,ans);
        return ans;
    }
    public void helper(int[] nums,int idx,List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int num: nums){
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(set.contains(nums[i]))continue;
            set.add(nums[i]);
            int temp=nums[idx];
            nums[idx]=nums[i];
            nums[i]=temp;
            helper(nums,idx+1,ans);
           int t=nums[idx];
            nums[idx]=nums[i];
            nums[i]=t; 
        }
    }
}
