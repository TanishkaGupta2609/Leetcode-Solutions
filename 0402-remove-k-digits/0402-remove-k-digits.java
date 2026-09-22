class Solution {
    public String removeKdigits(String num, int k) {
        String ans="";
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && st.peek()>num.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        while (!st.isEmpty()) { 
            ans = st.pop() + ans;
         }
        int i=0;
        while(i<ans.length() && ans.charAt(i)=='0'){
            i++;
        }
        ans=ans.substring(i);
        if(ans.equals(""))return "0";
        return ans;
    }
}