class Solution {
    public int getSum(int a, int b) {
        while((a&b) != 0){
            //if we have a carry
            int carry = a&b;// puts 1 on exactly where the carry exists
            int sum = a^b; // does the sum without carry
            carry = carry << 1;// puts the carry to step to the left to be added
            a = sum;//our sum without carray becomes a to be added on the next iteration
            b = carry;//our carry will become b to be added on the next iteration
        }
        return a|b;
    }
}
