class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<Integer[]> queue=new PriorityQueue<>((a,b)->a[0]+a[1]==b[0]+b[1]?b[0]-a[0]:a[0]+a[1]-b[0]-b[1]);
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                queue.offer(new Integer[]{i,j});
            }
        }
        int[] output=new int[queue.size()];
        int index=0;
        while(queue.size()>0){
            Integer[] current=queue.poll();
            output[index++]=nums.get(current[0]).get(current[1]);
        }
        
        return output;
    }
}
