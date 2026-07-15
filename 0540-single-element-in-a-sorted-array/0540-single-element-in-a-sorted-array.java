class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        if(nums[0]!=nums[1])return nums[0];
        int n=nums.length;
        if(nums[n-1]!=nums[n-2])return nums[n-1];
        int s=1;
        int e=n-2;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            else if(mid%2==0 && nums[mid]==nums[mid+1] || mid%2!=0 && nums[mid]==nums[mid-1]){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return -1;
    }
}