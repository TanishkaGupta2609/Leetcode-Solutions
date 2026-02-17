class Solution {
    public int search(int[] nums, int target) {
       int s=0;
       int e=nums.length-1;
       if(s>e)return -1;
       return binary(nums,s,e,target);
    }
    public int binary(int[] nums,int s,int e,int target){
        if(s>e)return -1;
        int m=e-(e-s)/2;
        if(nums[m]==target){
            return m;
        }
        else if(nums[m]>target){
            return binary(nums,s,m-1,target);
        }
        else{
            return binary(nums,m+1,e,target);
        }
    }
}
