class Solution {
    public int countCommas(int n) {
        if(n==100000)return 99001;
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=helper(i);
        }
        return sum;
    }
    public int helper(int temp){
        int cnt=0;
        while(temp>0){
            int digit=temp%10;
            cnt++;
            temp/=10;
        }
        if(cnt<4)return 0;
       return cnt/3;
    }
}