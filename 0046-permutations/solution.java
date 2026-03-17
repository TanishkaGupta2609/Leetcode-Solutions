class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> cur=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,0,cur,ans);
        return ans;
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void helper(int[] nums,int idx,List<Integer> cur,List<List<Integer>> ans){
        if(idx==nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            cur.add(nums[i]);
            swap(nums,idx,i);
            helper(nums,idx+1,cur,ans);
            cur.remove(cur.size()-1);
            swap(nums,idx,i);
        }
    }
}
