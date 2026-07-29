class Solution {
    public int splitArray(int[] nums, int k) {
        if(k>nums.length)return -1;
        int low=0;
        int high=0;
        for(int i=0;i<nums.length;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canWe(nums,mid)>k){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return low;
    }
    public int canWe(int[] nums,int mid){
        int cnt=1;
        int last=0;
        for(int num: nums){
            if(num+last<=mid){
                last+=num;
            }
            else{
                cnt++;
                last=num;
            }
        }
        return cnt;
    }
}