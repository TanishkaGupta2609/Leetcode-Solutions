class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int cnt=0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem = ((sum % k) + k) % k;
            cnt+=map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return cnt;
    }
}