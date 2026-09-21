class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        // for(int i=0;i<asteroids.length;i++){
        //     while(!st.isEmpty() && st.peek()>asteroids[i]){
        //         if(st.peek()>0 && asteroids[i]>0 || st.peek()<0 && asteroids[i]<0 ){
        //             st.push(asteroids[i]);
        //         }else{
        //             while(!st.isEmpty() && st.peek()>asteroids[i])st.pop();
        //         }
        //     }
        //     st.push(asteroids[i]);
        // }
        // List<Integer> list=new ArrayList<>();
        // while(!st.isEmpty()){
        //     list.add(st.pop());
        // }
        // int[] ans = list.stream()
        //        .mapToInt(Integer::intValue)
        //        .toArray();
        // return ans;
        for(int i=0;i<asteroids.length;i++){
            while(!st.isEmpty() && st.peek()>0 && asteroids[i]<0){
                if(st.peek()==-asteroids[i]){
                    st.pop();
                    asteroids[i]=0;
                    break;
                }
                else if(st.peek()<-asteroids[i]){
                   st.pop();
                }
                else{
                    asteroids[i]=0;
                    break;
                }
            }
            if(asteroids[i]!=0)st.push(asteroids[i]);
        }
        int[] ans=new int[st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}