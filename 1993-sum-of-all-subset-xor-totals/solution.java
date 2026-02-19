class Solution {
    public int subsetXORSum(int[] nums) {
        return result(nums,0,0);
    }
    public int result(int[] nums,int idx,int ans ){
        if(idx==nums.length){
            return ans;
        }
        int include=result(nums,idx+1,ans^nums[idx]);
        int exclude=result(nums,idx+1,ans);
        return include+exclude;
    }
}    
