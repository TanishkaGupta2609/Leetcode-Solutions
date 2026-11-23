// class Solution {
//     public int rob(int[] nums) {
//          int n=nums.length;
//         int[] dp=new int[n];
//         Arrays.fill(dp,-1);
//        // return helper(nums,n-1,dp);
//        dp[0]=nums[0];
//        for(int i=1;i<n;i++){
//         int take=nums[i];
//         if(i>1)take+=dp[i-2];
//         int notTake=dp[i-1];
//         dp[i]=Math.max(take,notTake);
//        }
//        return dp[n-1];
//     }
//     // public int helper(int[] nums,int idx,int[] dp){
//     //     if(idx==0)return nums[idx];
//     //     if(idx<0)return 0;
       
//     //     if(dp[idx]!=-1)return dp[idx];
//     //     int pick=nums[idx]+helper(nums,idx-2,dp);
//     //     int notpick=helper(nums,idx-1,dp);
//     //     return dp[idx]=Math.max(pick,notpick);
//     // }
// }

class Solution{
    public int rob(int[] nums){
        int n=nums.length;
        if(n==1)return nums[0];
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
           int take=prev2+nums[i];
           int not=prev1;
           int cur=Math.max(take,not);
           prev2=prev1;
           prev1=cur;
        }
        return prev1;
    }
}