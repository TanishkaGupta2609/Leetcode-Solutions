class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int num:nums){
            high=Math.max(num,high);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            int ans=0;
            for(int num:nums){
                ans+=(num+mid-1)/mid;
                if(ans>threshold)break;
            }
            if(ans<=threshold){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}