class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int maxProd=nums[0];
        int minProd=nums[0];
        for(int i=1;i<nums.length;i++){
            int cur=nums[i];
            if(cur<0){
                int temp=minProd;
                minProd=maxProd;
                maxProd=temp;
            }
            minProd=Math.min(cur,cur*minProd);
            maxProd=Math.max(cur,cur*maxProd);
            ans=Math.max(ans,maxProd);
        }
        return ans;
    }
}