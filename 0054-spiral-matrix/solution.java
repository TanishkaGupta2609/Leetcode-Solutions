class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> ans=new ArrayList<>();
        int top=0;
        int bottom=m-1;
        int right=0;
        int left=n-1;
        while(top<=bottom && right<=left){
            for(int i=right;i<=left;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][left]);
            }
            left--;
            if(top<=bottom){
            for(int i=left;i>=right;i--){
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            }

            
            if(right<=left){
                for(int i=bottom;i>=top;i--){
                ans.add(matrix[i][right]);
                
            }
            right++;
            }
            
        }
        return ans;
    }
}
