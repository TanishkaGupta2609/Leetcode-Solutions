class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        int left=0;
        int cnt=0;
        HashSet<Character> set=new HashSet<>();
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            cnt=Math.max(cnt,right-left+1);
        }
        return cnt;
        */
        int l=0;
        int r=0;
        int n=s.length();
        int[] hash=new int[255];
        for(int i=0;i<255;i++){
            hash[i]=-1;
        }
        int maxLen=0;
        while(r<n){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)]>=l){
                    l=hash[s.charAt(r)]+1;
                }
            }
            int len=r-l+1;
            maxLen=Math.max(len,maxLen);
            hash[s.charAt(r)]=r;
            r++;
        }
        return maxLen;
    }
}