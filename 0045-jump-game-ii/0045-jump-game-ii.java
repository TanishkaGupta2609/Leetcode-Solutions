class Solution {
    public int jump(int[] nums) {
        int maxIdx=0;//farthest he can go
        int jump=0;
        int currentEnd=0;// currently standing at which idx
        for(int i=0;i<nums.length-1;i++){
            maxIdx=Math.max(maxIdx,i+nums[i]);
            if(i==currentEnd){
                jump++;
                currentEnd=maxIdx;
            }
        }
        return jump;
    }
}