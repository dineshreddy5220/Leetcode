class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder input=new StringBuilder();
        for(int i=0;i<s.length();i++){
            input.append(s.charAt(i));
            char curr=s.charAt(i);
            if(input.length()>=k){
                int len=input.length();
                String sub=input.substring(len-k,len);
                int start=0,end=sub.length()-1;
                while(start<end && sub.charAt(start)==curr && curr==sub.charAt(end)){
                    start++;
                    end--;
                }
                if(start>=end){
                    input.delete(len-k, len);
                }
            }
        }
        return input.toString();
    }
}