class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> final_board=new ArrayList<>();
        char[][] chessboard=new char[n][n];//first part of algorithm
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessboard[i][j]='.';
            }
        }
        createConfig(final_board,chessboard,0);//second part of algorithm
        return final_board;//third part of algortihm
    }
    public void createConfig(List<List<String>> final_board, char chessboard[][],int row){
        if(row==chessboard.length){
            final_board.add(boardToString(chessboard));
            return;
        }
        for(int col=0;col<chessboard.length;col++){
            if(isValid(chessboard,row,col)){
                chessboard[row][col]='Q';
                createConfig(final_board,chessboard,row+1);
                chessboard[row][col]='.';
            }
        }
    }
    public boolean isValid(char[][] chessboard,int row,int col){
        for(int i=0;i<chessboard.length;i++){
            if(chessboard[row][i]=='Q')return false;
        }
        for(int i=0;i<chessboard.length;i++){
            if(chessboard[i][col]=='Q')return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(chessboard[i][j]=='Q')return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<chessboard.length;i--,j++){
             if(chessboard[i][j]=='Q')return false;
        }
        return true;
    }
    public List<String> boardToString(char[][] chessboard){
        List<String> list=new ArrayList<>();
        for(int i=0;i<chessboard.length;i++){
            String rowString=new String(chessboard[i]);
            list.add(rowString);
        }
        return list;
    }
}