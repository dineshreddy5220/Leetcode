class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=S.charAt(i)){
                sb.append(S.charAt(i));
            }
            else{
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}