class Solution {
    public boolean isPowerOfTwo(int n) {
        int ans=power(n);
        if(ans==-1){
            return false;
        }
        return true;
    }
    public int power(int n){
        if(n==0)return -1;
        if(n==1){
            return 1;
        }
        if(n%2==0){
            return power(n/2);
        }
        else{
            return -1;
        }
    }
}
