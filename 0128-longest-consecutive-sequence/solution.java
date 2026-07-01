class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int ans=0;
        for(int i: nums){
            set.add(i);
        }
        for(int i: set){
            if(!set.contains(i-1)){
            int len=1;
            while(set.contains(i+len)){
                len++;
            }
            
            ans=Math.max(ans,len);
            }
        }
        return ans;
            }
}  
