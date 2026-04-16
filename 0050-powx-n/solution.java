class Solution {
    public double myPow(double x, int n) {
      
       long num=n;
       if(num<0){
        x=1/x;
        num=-num;
       }
       return helper(x,num);
    }
    public double helper(double x,long num){
 if(num==0)return 1;
        double half=helper(x,num/2);
        if(num%2==0){
            return half * half;
        }
        else{
            return x* half * half;
        }
    }
}
