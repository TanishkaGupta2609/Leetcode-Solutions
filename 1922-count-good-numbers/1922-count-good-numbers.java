class Solution {
    static final long mod=1000000007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long ans=power(5,even)*power(4,odd)%mod;
        return (int)ans;
    }
    public long power(long x,long n){
        long ans=1;
        while(n>0){
            if(n%2==1){
                ans=ans*x%mod;
                n--;
            }else{
                x=x*x%mod;
                n/=2;
            }
        }
        return ans;
    }
}