class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> str=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!str.isEmpty() && str.peek()==ch){
                str.pop();
            }
            else str.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        for(char c:str){
            sb.append(c);
        }
        return sb.toString();
    }
}
