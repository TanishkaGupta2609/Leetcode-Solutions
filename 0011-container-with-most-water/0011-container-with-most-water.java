class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int width=0;
        int area=0;
        int ans=0;
        while(left<right){
            width=right-left;
            area=(Math.min(height[right],height[left]))*width;
            ans=Math.max(area,ans);
            if(height[right]<height[left]){
                right--;
            }
            else{
                left++;
            }
        }
        return ans;
    }
}