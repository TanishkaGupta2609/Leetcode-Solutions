class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=helper(mat,n,m,mid);
            int left=mid-1>=0?mat[row][mid-1]:-1;
            int right=mid+1<m?mat[row][mid+1]:-1;
            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row,mid};
            }else if(left>mat[row][mid])high=mid-1;
            else low=mid+1;
        }
        return new int[]{-1,-1};
    }
    public int helper(int[][] mat,int n,int m,int mid){
        int idx=-1;
        int val=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(mat[i][mid]>val){
                val=mat[i][mid];
                idx=i;
            }
        }
        return idx;

    }
}