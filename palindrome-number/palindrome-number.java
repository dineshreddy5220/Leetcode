class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x>=0 && x<=9){
            return true;
        }
        int length=(int)(Math.log(x)/Math.log(10));
        length++;
        int reverse=0;
        for(int i=0;i<length/2;i++){
            reverse=reverse*10+x%10;
            x=x/10;
        }
        if(length%2==1){
             x=x/10;
        }
        return x==reverse;
    }
}
