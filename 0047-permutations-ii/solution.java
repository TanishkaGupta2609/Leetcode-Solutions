class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        helper(ans,cur,nums,used);
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> cur,int[] nums, boolean[] used){
        if(cur.size()==nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1])continue;
            used[i]=true;
            cur.add(nums[i]);
            helper(ans,cur,nums,used);
            cur.remove(cur.size()-1);
            used[i]=false;
        }
    }
}
