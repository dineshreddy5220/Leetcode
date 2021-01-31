class Solution {
    boolean flag=false;
    public int[][] candyCrush(int[][] board) {
        flag=true;
        while(flag){
            flag=false;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]!=0){
                        boolean down=false;
                        if(i<board.length-2){
                            down=true;
                        }
                        boolean right=false;
                        if(j<board[0].length-2){
                            right=true;
                        }
                        updateToNegative(board,i,j ,down,right);
                    }
                }
            }
            if(!flag){
                return board;
            }
            for(int[] rows:board){
                for(int i=0;i<rows.length;i++){
                    if(rows[i]<0){
                        rows[i]=0;
                    }
                }
            }
            for(int i=0;i<board[0].length;i++){
                int curr=board.length-1;
                for(int j=board.length-1;j>=0;j--){
                    if(board[j][i]!=0){
                        int temp=board[j][i];
                        board[j][i]=board[curr][i];
                        board[curr][i]=temp;
                        curr--;
                    }
                }
            }
        }
        return board;
        
    }
    public void updateToNegative(int[][] board , int i, int j, boolean down,boolean right){
        if(down && Math.abs(board[i][j])==Math.abs(board[i+1][j]) 
           && Math.abs(board[i+1][j])==Math.abs(board[i+2][j])){
            board[i][j]=-1*Math.abs(board[i][j]);
            board[i+1][j]=-1*Math.abs(board[i+1][j]);
            board[i+2][j]=-1*Math.abs(board[i+2][j]);
            flag=true;
        }
        if(right && Math.abs(board[i][j])==Math.abs(board[i][j+1]) 
           && Math.abs(board[i][j+1])==Math.abs(board[i][j+2])){
            board[i][j]=-1*Math.abs(board[i][j]);
            board[i][j+1]=-1*Math.abs(board[i][j+1]);
            board[i][j+2]=-1*Math.abs(board[i][j+2]);
            flag=true;
        }
    }
}