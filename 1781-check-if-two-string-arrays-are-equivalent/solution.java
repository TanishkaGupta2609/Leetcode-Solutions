class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word1ans=String.join("",word1);
        String word2ans=String.join("",word2);
        if(word1ans.equals(word2ans)){
            return true;
        }
        return false;
    }
}
