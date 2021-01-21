class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int result=0;
        for(int t:time){
            t%=60;
            int temp=(60-t)%60;
            if(map.containsKey(temp)){
                result+=map.get(temp);
            }
            
            map.put(t,map.getOrDefault(t,0)+1);
        }
        return result;
    }
}
