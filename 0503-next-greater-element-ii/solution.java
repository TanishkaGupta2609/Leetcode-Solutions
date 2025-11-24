class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge=new int[nums.length];
        int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty())nge[i]=-1;
                else nge[i]=stack.peek();
            }
            stack.push(nums[i%n]);
        }
        return nge;
    }
}
