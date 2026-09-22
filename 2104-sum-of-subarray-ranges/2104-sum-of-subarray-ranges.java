class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long maxAns=0;
        long minAns=0;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=i+1;
            }else{
                left[i]=i-st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]=n-i;
            }else{
                right[i]=st.peek()-i;
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            minAns+=(long)nums[i]*left[i]*right[i];
        }
        st.clear();
        Arrays.fill(left,0);
        Arrays.fill(right,0);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=i+1;
            }else{
                left[i]=i-st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]=n-i;
            }else{
                right[i]=st.peek()-i;
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            maxAns+=(long)nums[i]*left[i]*right[i];
        }
        long ans=maxAns-minAns;
        return ans;
    }
}