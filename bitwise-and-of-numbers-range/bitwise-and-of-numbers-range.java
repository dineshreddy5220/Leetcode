class Solution {
    public int rangeBitwiseAnd(int m, int n) {
       if(n==m){
           return m;
       }
        while(n>m){
            n=n&(n-1);
        }
        return n;
    }
}
