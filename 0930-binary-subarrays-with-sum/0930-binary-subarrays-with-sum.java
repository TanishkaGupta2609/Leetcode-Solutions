class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal)-helper(nums,goal-1);
    }
    public int helper(int[] nums,int k){
        if(k<0)return 0;
         int l=0;
        int r=0;
        int sum=0;
        int len=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>k){
                sum-=nums[l];
                l++;
            }
            len+=r-l+1;
            r++;
        }
    return len;
    }
}