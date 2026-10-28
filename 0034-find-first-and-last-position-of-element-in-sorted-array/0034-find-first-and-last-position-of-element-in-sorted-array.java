class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        int[] ans={-1,-1};
        while(s<=e){
            int mid=s+(e-s)/2;
            if(target==nums[mid]){
                ans[1]=mid;
                e=mid-1;
            }else if(target<nums[mid]){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        s=0;
        e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(target==nums[mid]){
                ans[0]=mid;
                s=mid+1;
            }else if(target>nums[mid]){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}