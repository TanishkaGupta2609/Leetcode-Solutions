class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> ans=new ArrayList<>();
       char[][] board = new char[n][n];
       for(char[] row: board){
        Arrays.fill(row,'.');
       } 
       helper(0,board,ans,n);
       return ans;
    }
    public void helper(int row,char[][] board,List<List<String>> ans,int n){
        if(row==n){
            List<String> res=new ArrayList<>();
            for(char[] r:board){
                res.add(new String(r));
            }
            ans.add(res);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                helper(row+1,board,ans,n);
                board[row][col]='.';
            }
        }
    }
    public boolean isSafe(int row,int col,char[][] board,int n){
        //check same column
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q')return false;
        }
        //check upper left diagnol
        for(int i=row-1, j=col-1;i>=0 && j>=0;i--, j--){
            if(board[i][j]=='Q')return false;
        }
        //check upper-right diagnol
        for (int i=row - 1,j=col+1;i>=0&&j<n;i--,j++) {
            if (board[i][j] == 'Q')return false;
        }
        return true;
    }
}