class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int[] interval:intervals){
            if(list.size()>0){
                int[] prev=list.get(list.size()-1);
                if(prev[1]<interval[0]){
                    list.add(interval);
                }
                else{
                    prev[1]=Math.max(prev[1],interval[1]);
                }
            }
            else{
                list.add(interval);
            }
        }
        int[][] output=new int[list.size()][2];
        int i=0;
        for(int[] interval:list){
            output[i++]=interval;
        }
        return output;
    }
}