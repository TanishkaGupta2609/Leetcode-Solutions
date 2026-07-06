class Solution {
    public int majorityElement(int[] nums) {
        int cand=nums[0];
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                cand=nums[i];
               
            }
            if(cand==nums[i]){
                cnt++;
            }
            else {
                cnt--;
            }
            
        }
        return cand;
    }
}
