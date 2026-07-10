class Solution {
    public long countSubarrays(int[] nums, long k) {
        int l=0;
        long cnt=0;
        long sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum*(r-l+1)>=k){
                sum-=nums[l];
                l++;

            }
            cnt+=r-l+1;
        }
        return cnt;
    }
}