class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int i=0;
        for(int num:arr2){
            int frequency=map.get(num);
            while(frequency>0){
                arr1[i++]=num;
                frequency--;
            }
            map.remove(num);
        }
        List<Integer> sortedList=new ArrayList<>(map.keySet());
        Collections.sort(sortedList);
        for(int num:sortedList){
            int frequency=map.get(num);
            while(frequency>0){
                arr1[i++]=num;
                frequency--;
            }
            map.remove(num);
        }
        return arr1;
    }
}
