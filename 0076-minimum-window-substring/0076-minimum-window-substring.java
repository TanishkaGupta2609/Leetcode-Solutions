class Solution {
    public String minWindow(String s, String t) {
        int[] hash=new int[256];
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }
        int l=0;
        int r=0;
        int startIdx=-1;
        int minLen=Integer.MAX_VALUE;
        int cnt=0;
        while(r<s.length()){
            if(hash[s.charAt(r)]>0){
                cnt++;
            }
            hash[s.charAt(r)]--;
            while(cnt==t.length()){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    startIdx=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0){
                    cnt--;
                }
                l++;
            }
            
            r++;
        }
        return startIdx==-1?"":s.substring(startIdx,startIdx+minLen);
    }
}