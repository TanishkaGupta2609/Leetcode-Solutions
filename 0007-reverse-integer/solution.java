class Solution {
    public int reverse(int x) {
        int sign= x<0? -1:1;
        long num=Math.abs((long)x);
        long result=(long)helper(num);
        result*=sign;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int)result;
    }
    public long helper(long x){
        if(x<=9){
            return x;
        }
        long rem=x%10;
        int digits=(int)Math.log10(x);
        return rem*(int)Math.pow(10,digits)+helper(x/10);
    }
}
