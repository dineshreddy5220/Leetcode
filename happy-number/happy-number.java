class Solution {
    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        HashSet<Integer> set=new HashSet<>();
        while(set.add(n)){
            n=sum(n);
            if(n==1){
                return true;
            }
        }
        return false;
    }
    public int sum(int n){
        int sum=0;
        while(n!=0){
            int remainder=n%10;
            sum+=remainder*remainder;
            n/=10;
        }
        return sum;
    }
}
