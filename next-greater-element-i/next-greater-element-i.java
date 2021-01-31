class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nextGreater=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(stack.size()>0 && stack.peek()<nums2[i]){
                stack.pop();
            }
            nextGreater.put(nums2[i],stack.size()==0?-1:stack.peek());
            stack.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=nextGreater.get(nums1[i]);
        }
        return nums1;
    }
}