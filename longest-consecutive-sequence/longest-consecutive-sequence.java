class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int longest=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                longest++;
            }
            else if(nums[i]==nums[i-1]){
                
            }
            else{
                longest=1;
            }
            max=Math.max(max,longest);
        }
        return max;
    }
}
