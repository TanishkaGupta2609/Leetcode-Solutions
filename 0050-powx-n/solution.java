class Solution {
    public double myPow(double x, int n) {
         double N=n;
        if(n<0){
           N=-N;
            x=1/x;
        }   
        return helper(x,n); 
    }
    public double helper(double x,int n){
        if(n==0)return 1;
        double half=helper(x,n/2);
        if(n%2==0){
            return half*half;
        }
        else{
            return x*half*half;
        }
    }

}
