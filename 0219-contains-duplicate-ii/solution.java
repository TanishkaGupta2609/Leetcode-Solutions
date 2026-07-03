class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
     HashMap<Integer,Integer> map=new HashMap<>();
     for(int i=0;i<nums.length;i++){
        
        if(!map.containsKey(nums[i])){
            map.put(nums[i],i);
        }
        else{
            int temp=map.get(nums[i]);
            if(Math.abs(temp-i)<=k){
                return true;
            }
            map.put(nums[i],i);
        }
        /*
        if(map.containsKey(nums[i])){
            if(Math.abs(i-map.get(nums[i]))<=k)return true;
        }
        map.put(nums[i],i);
        */
     }  
     return false; 
    }
}
