class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        helper(ans,cur,nums,0);
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> cur,int[] nums,int idx){
        if(idx==nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[idx]);
        helper(ans,cur,nums,idx+1);
        cur.remove(cur.size()-1);
        helper(ans,cur,nums,idx+1);
    }
}
