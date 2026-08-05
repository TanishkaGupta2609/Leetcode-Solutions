class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int temp=0;
        int ans=0;
        while(r<nums.length){
            if(nums[r]==0){
                temp++;
            }
            if(temp>k){
                if(nums[l]==0){
                    temp--;
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}