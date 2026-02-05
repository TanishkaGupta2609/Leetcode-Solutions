class Solution {
    List<List<Integer>>sol = new ArrayList<>();
    public void solve(int i, int []candi,ArrayList<Integer>ans, int t){
        if(t<0){
            return;
        }
        if(t==0){
            sol.add(new ArrayList<>(ans));
            return;
        }
        for(int j=i;j<candi.length;j++){
            if(j==i || candi[j]!=candi[j-1] && t>=0){
                ans.add(candi[j]);
                solve(j,candi,ans,t-candi[j]);
                ans.remove(ans.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candi, int target) {
        Arrays.sort(candi);
        ArrayList<Integer>ans = new ArrayList<>();
        solve(0,candi,ans,target);
        return sol;
    }
}
