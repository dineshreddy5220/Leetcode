/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    int ships;
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        dfs(sea,topRight,bottomLeft);
        return ships;
    }
    public void dfs(Sea sea,int[] topRight, int[] bottomLeft){
        if(ships ==10 || !sea.hasShips(topRight,bottomLeft) ){
            return;
        }
        if(topRight[0]==bottomLeft[0] && topRight[1]==bottomLeft[1]){
            ships++;
            return;
        }
        int middleX=(topRight[0]+bottomLeft[0])/2;
        int middleY=(topRight[1]+bottomLeft[1])/2;
        dfs(sea,new int[]{middleX,middleY},bottomLeft);
        dfs(sea,topRight,new int[]{middleX+1,middleY+1});
        dfs(sea,new int[]{middleX,topRight[1]},new int[]{bottomLeft[0],middleY+1});
        dfs(sea,new int[]{topRight[0],middleY},new int[]{middleX+1,bottomLeft[1]});
    }
}