class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int case1=solve(nums,0,n-2);
        int case2=solve(nums,1,n-1);
        return Math.max(case1,case2);
    }
    public int solve(int[] nums,int s,int e){
        int prev1=0;
        int prev2=0;
        for(int i=s;i<=e;i++){
            int rob=nums[i]+prev2;
            int skip=prev1;
            int cur=Math.max(rob,skip);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}