class Solution {
    public void reverseString(char[] s) {
       int b=0;
       int e=s.length-1;
       reverse(s,b,e);
       System.out.println(new String(s));
    }
    public char[] reverse(char[] s,int b,int e){
        if(b>=e)return s;
        char temp=s[b];
        s[b]=s[e];
        s[e]=temp;
        return reverse(s,b+1,e-1);
    }
}
