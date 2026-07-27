class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k)return -1;
        int result=0;
        int maxDay=Integer.MIN_VALUE;
        int minDay=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            maxDay=Math.max(maxDay,bloomDay[i]);
            minDay=Math.min(minDay,bloomDay[i]);
        }
        int low=minDay;
        int high=maxDay;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(bloomDay,mid,m,k)){
                result=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return result;
    }
    public boolean isPossible(int[] bloomDay,int day ,int m, int k){
        int cnt=0;
        int bouq=0;
        for(int bloom : bloomDay){
            if(bloom<=day){
                cnt++;
            }else{
                bouq+=(cnt/k);
                cnt=0;
            }
        }
        bouq+=(cnt/k);
        return bouq>=m;
    }

}