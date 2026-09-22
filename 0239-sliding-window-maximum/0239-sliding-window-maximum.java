class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                ans.add(nums[dq.peekFirst()]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}