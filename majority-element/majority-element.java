class Solution {
    public int majorityElement(int[] nums) {
        int num=nums[0];
        int frequency=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=num){
                frequency--;
                if(frequency==0){
                    num=nums[i];
                    frequency=1;
                }
                
            }
            else{
                frequency++;
            }
        }
        return num;
    }
}