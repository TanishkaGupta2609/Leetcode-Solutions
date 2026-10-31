class Solution {
    public int rob(int[] nums) {
        int prev2=0;
        int prev1=0;
        for(int i=0;i<nums.length;i++){
            int rob=nums[i]+prev2;
            int skip=prev1;
            int cur=Math.max(rob,skip);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}