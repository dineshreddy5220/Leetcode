import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ascOrder=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int position=binarySearch(ascOrder, nums[i]);
            if(position>=ascOrder.size()){
                ascOrder.add(nums[i]);
            }
            else{
                ascOrder.set(position,nums[i]);
            }
        }
        return ascOrder.size();
    }
    public int binarySearch( ArrayList<Integer> list, int num){
        int start=0;
        int end=list.size();
        while(start!=end){
            int middle=(start+end)/2;
            if(list.get(middle)<num){
                start=middle+1;
            }
            else{
                end=middle;
            }
        }
        return start;
    }
}
