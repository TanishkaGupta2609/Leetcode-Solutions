class Solution {
    public String shortestPalindrome(String s) {
        String st=new StringBuilder(s).reverse().toString();
        String combined=s+'#'+st;
        int n=combined.length();
        int[] lps=new int[n];
        int len=0;
        int i=1;
        while(i<n){
            if(combined.charAt(i)==combined.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return st.substring(0,s.length()-lps[n-1])+s;
    }
}