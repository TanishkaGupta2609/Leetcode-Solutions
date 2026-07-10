class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int zero=0;
        int cnt=0;
        for(int r=0;r<nums.length;r++){

            if(nums[r]==0){
                zero++;
            }
            while(zero>k){
                if(nums[left]==0){
                    zero--;
                }
                left++;
            }
            cnt=Math.max(cnt,r-left+1);
        }
        return cnt;
    }
}
