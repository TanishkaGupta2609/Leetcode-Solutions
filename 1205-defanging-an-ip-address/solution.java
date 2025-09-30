class Solution {
    public String defangIPaddr(String address) {
        String newstr=address.replace(".","[.]");
        return newstr;
    }
}
