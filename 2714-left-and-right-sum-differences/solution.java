class Solution {
    public int[] leftRightDifference(int[] nums) {
        int l=0;
       
        int n=nums.length;
        int sum=0;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
         int r=sum;
        for(int i=0;i<n;i++){
            r-=nums[i];
            l=sum-r-nums[i];
            ans[i]=Math.abs(r-l);
        }
        return ans;
    }
}
