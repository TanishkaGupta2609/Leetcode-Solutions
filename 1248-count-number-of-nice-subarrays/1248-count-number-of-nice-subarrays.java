class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    public int atMost(int[] nums,int k){
        int l=0;
        int r=0;
        int ans=0;
        while(r<nums.length){
            if(nums[r]%2!=0){
                k--;
            }
           while(k<0){
            if(nums[l]%2!=0){
                k++;
            }
            l++;
           }
           
           ans+=r-l+1;
           r++; 
        }
        return ans;
    }
}