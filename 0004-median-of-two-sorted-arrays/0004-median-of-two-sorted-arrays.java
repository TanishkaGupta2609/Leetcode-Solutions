class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        int i=0;
        int j=0;
        int prev=0;
        int cur=0;
        for(int k=0;k<=len/2;k++){
            prev=cur;
            if(i<nums1.length && (j==nums2.length || nums1[i]<=nums2[j])){
                cur=nums1[i];
                i++;
            }else{
                cur=nums2[j];
                j++;
            }
        }
        if(len%2!=0){
            return cur;
        }
      return (prev+cur)/2.0;  
    }
}