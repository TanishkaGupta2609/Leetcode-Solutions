class Solution {
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        String lower=s.toLowerCase();
        // String first=s.substring(0,n/2);
        // String second=s.substring(n/2);
        int count1=0;
        int count2=0;
        String vowel="aeiou";
        for(int i=0;i<n;i++){
            char c=lower.charAt(i);
            if(vowel.indexOf(c)!=-1){
                if(i<n/2)count1++;
                else count2++;
            }
        }
        return count1==count2;
    }
}
