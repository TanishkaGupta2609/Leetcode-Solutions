class Solution {
    public int commonFactors(int a, int b) {
        int cnt=0;
        int num=Math.max(a,b);
        for(int i=1;i<=num;i++){
            if(a%i==0 && b%i==0){
                cnt++;
            }
        }
        return cnt;
    }
}