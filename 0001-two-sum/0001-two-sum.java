class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i !=j && nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            } 
        }
        return ans;
        */
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                ans[0]=map.get(temp);
                ans[1]=i;
                return ans;
            }
            map.put(nums[i],i);
        } 
        return ans;
    }
}