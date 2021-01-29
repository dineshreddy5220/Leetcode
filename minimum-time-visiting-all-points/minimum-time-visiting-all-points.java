class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int timer=0;
        int[] start=points[0];
        for(int[] point:points){
            while(point[0]!=start[0] || point[1]!=start[1]){
                if(point[0]>start[0]){
                    start[0]++;
                }
                else if(point[0]<start[0]){
                    start[0]--;
                }
                if(point[1]>start[1]){
                    start[1]++;
                }
                else if(point[1]<start[1]){
                    start[1]--;
                }
                timer++;
            }
        }
        return timer;
    }
}