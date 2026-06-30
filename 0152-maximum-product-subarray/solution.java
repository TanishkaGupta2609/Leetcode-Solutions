class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int maxProd=nums[0];
        int minProd=nums[0];
        for(int i=1;i<nums.length;i++){
            int cur=nums[i];
            if(cur<0){
                int temp=maxProd;
                maxProd=minProd;
                minProd=temp;
            }
            maxProd=Math.max(cur,maxProd*cur);
            minProd=Math.min(cur,minProd*cur);
            ans=Math.max(ans,maxProd);
        }
        return ans;
    }
}
