class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengers=new int[1001];
        for(int[] trip:trips){
            int cnt=trip[0];
            int from=trip[1];
            int to=trip[2];
            passengers[from]+=cnt;
            passengers[to]-=cnt;
        }
        int cur=0;
        for(int people:passengers){
            cur+=people;
            if(cur>capacity){
                return false;
            }
        }
        return true;
    }
}