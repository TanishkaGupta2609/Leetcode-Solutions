class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=count(i);
        }
        return ans;
    }
    public int count(int t){
        int cnt=0;
        while(t!=0){
            if((t&1)==1){
                cnt++;
            }
            t=t>>1;
        }
        return cnt;
    }
}
