class Solution {
    public int twoCitySchedCost(int[][] costs) {
       int costForA=0;
        for(int [] cost:costs)
            costForA+=cost[0];
        Integer[] difference=new Integer[costs.length];
        int i=0;
        for(int [] cost:costs)
            difference[i++]=cost[1]-cost[0];
        Arrays.sort(difference,(a,b)-> a.compareTo(b));
        for(int j=0;j<difference.length/2;j++){
            costForA+=difference[j];
        }
        return costForA;
    }
}