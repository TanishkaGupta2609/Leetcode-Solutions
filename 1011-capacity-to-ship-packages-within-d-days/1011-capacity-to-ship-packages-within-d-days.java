class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            maxWeight=Math.max(maxWeight,weights[i]);
            sum+=weights[i];
        }
        int low=maxWeight;
        int high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(weights,mid)<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int isPossible(int[] weights,int m){
        int load=0;
        int days=1;
        for(int weight: weights){
            if(load+weight>m){
                load=weight;
                days++;
            }else{
                load+=weight;
            }
        }
        return days;
    }
}