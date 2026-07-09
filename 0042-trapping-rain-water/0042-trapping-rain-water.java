class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int leftMax=height[0];
        int rightMax=height[height.length-1];
        int ans=0;
        /*
        //runtime is 0ms
        while(left<=right){
            if(height[left]<height[right]){
                leftMax=Math.max(leftMax,height[left]);
                    ans+=leftMax-height[left];
                left++;
            }
            else{
                rightMax=Math.max(rightMax,height[right]);
                    ans+=rightMax-height[right];
                right--;
            }
        }
        */
        //runtime is 1ms
        while(left<right){
            if(leftMax<rightMax){
                ans+=Math.min(leftMax,rightMax)-height[left];
                left++;
                leftMax=Math.max(leftMax,height[left]);
            }
            else{
                ans+=Math.min(leftMax,rightMax)-height[right];
                right--;
                rightMax=Math.max(rightMax,height[right]);
            }
        }
        return ans;
    }
}