class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result=new int[2*n];
        for(int k=0,i=0,j=n;j<nums.length;i++,j++,k++){
            result[k]=nums[i];
            k++;
            result[k]=nums[j];
        }
        return result;
    }
}