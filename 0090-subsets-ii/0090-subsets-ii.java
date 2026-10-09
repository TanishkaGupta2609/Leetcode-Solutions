class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
         List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        helper(nums,0,cur,ans);
        return ans;
    }
    public void helper(int[] nums,int idx,List<Integer> cur,List<List<Integer>> ans){
        ans.add(new ArrayList<>(cur));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])continue;
            cur.add(nums[i]);
            helper(nums,i+1,cur,ans);
            cur.remove(cur.size()-1);
        }
    }
}