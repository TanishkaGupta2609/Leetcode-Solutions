class Solution {
    public boolean canJump(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(i>idx)return false;
            idx=Math.max(idx,nums[i]+i);
        }
        return true;
    }
}