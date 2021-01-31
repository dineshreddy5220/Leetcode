class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex=0;
        int nonZeroIndex=0;
        while(zeroIndex<nums.length && nonZeroIndex<nums.length ){
            while(zeroIndex<nums.length && nums[zeroIndex]!=0){
                zeroIndex++;
            }
            nonZeroIndex=zeroIndex+1;
            while(nonZeroIndex<nums.length && nums[nonZeroIndex]==0){
                nonZeroIndex++;
            }
            if(zeroIndex<nums.length && nonZeroIndex<nums.length){
                nums[zeroIndex]=nums[nonZeroIndex];
                nums[nonZeroIndex]=0;
            }
            zeroIndex++;
        }
    }
}