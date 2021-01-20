class Solution {
    public int minTaps(int n, int[] ranges) {
        int taps=0;
        int max=0;
        int min=0;
        while(max<n){
            for(int i=0;i<ranges.length;i++){
                if(ranges[i]+i>max && i-ranges[i]<=min){
                    max=ranges[i]+i;
                }
            }
            if(min==max){
                return -1;
            }
            min=max;
            taps++;
        }
        return taps;
    }
}
