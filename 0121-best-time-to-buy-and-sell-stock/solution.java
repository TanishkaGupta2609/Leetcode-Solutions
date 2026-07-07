class Solution {
    public int maxProfit(int[] prices) {
        int minNum=prices[0];
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(minNum>prices[i])minNum=prices[i];
            else{
                maxProfit=Math.max(prices[i]-minNum,maxProfit);
            }
           
        }
        return maxProfit;
    }
}
