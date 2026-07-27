class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
                if(binarySearch(matrix[i],target))return true;
        }
        return false;
    }
    public boolean binarySearch(int[] arr,int t){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==t){
                return true;
            }else if(arr[mid]>t){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}