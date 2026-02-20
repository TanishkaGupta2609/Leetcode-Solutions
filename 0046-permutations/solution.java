class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        helper(nums,0,used,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] nums,int idx,boolean[] used,List<Integer> current,List<List<Integer>> ans){
        if(current.size()==nums.length){
            ans.add(new ArrayList<>(current));
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true)continue;
            used[i]=true;
            current.add(nums[i]);
            helper(nums,i,used,current,ans);
            current.remove(current.size()-1);
            used[i]=false;
        }
    }
}
