class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        if(n<1)return false;
        Stack<Integer> st=new Stack<>();
        int third=Integer.MIN_VALUE;
        for(int l=n-1;l>=0;l--){
            if(nums[l]<third)return true;
            while(!st.isEmpty() && nums[l]>st.peek())
            third=st.pop();
            st.push(nums[l]);
        }
        return false;
    }
}