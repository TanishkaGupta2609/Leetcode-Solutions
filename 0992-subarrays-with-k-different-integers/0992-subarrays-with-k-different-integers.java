class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    public int atMost(int[] nums,int k){
        if(k==0 || nums.length==0)return 0;
        int r=0;
        int l=0;
        int ans=0;
        HashMap<Integer,Integer> freq=new HashMap<>();
        while(r<nums.length){
            freq.put(nums[r],freq.getOrDefault(nums[r],0)+1);
            while(freq.size()>k){
                freq.put(nums[l],freq.get(nums[l])-1);
                if(freq.get(nums[l])==0)freq.remove(nums[l]);
                l++;
            }
            ans+=r-l+1;
            r++;
        }
        return ans;
    }
}