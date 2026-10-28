class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
       int sum=0;
       int n=nums.length;
       for(int i=0;i<nums.length;i++){
        if(i>0 && nums[i]==nums[i-1])continue;
        int right=i+1;
        int left=n-1;
        while(right<left){
             sum=nums[i]+nums[right]+nums[left];
        if(sum==0){
            list.add(Arrays.asList(nums[i],nums[right],nums[left]));
                left--;
                right++;
            while(right<left && nums[right]==nums[right-1]){
                right++;
            }
            while(right<left && nums[left]==nums[left+1]){
                left--;
            }
            
            }
        else if(sum<0)right++;
            else left--;
        }
       
        
       }
       return list;
    }
}