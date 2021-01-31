class Solution {
    int[][] fourSides=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int islandPerimeter(int[][] grid) {
        int perimeter=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    perimeter+=connectedArea(grid,i,j);
                }
            }
        }
        return perimeter;
    }
    public int connectedArea(int[][] grid, int row, int col){
        int sides=0;
        for(int[] dir:fourSides){
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            if(newRow<0 || newRow>=grid.length ||newCol<0 || newCol>=grid[0].length || grid[newRow][newCol]!=1){
                sides++;
            }
        }
        return sides;
    }
}