class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            N = -N;
        }

        double ans = helper(x, N);

        if (n < 0) {
            return 1.0 / ans;
        }

        return ans;
        // double ans=1.0;
        // long nn=n;
        // if(nn<0)nn=-1*nn;
        // while(nn>0){
        //     if(nn%2==1){
        //         ans=ans*x;
        //         nn--;
        //     }else{
        //         x*=x;
        //         nn/=2;
        //     }
        // }
        // if(n<0)ans=1.0/ans;
        // return ans;
    }

    public double helper(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = helper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }

        return x * half * half;
    }
}