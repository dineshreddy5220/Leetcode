class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        if(s.length()<2){
            return s;
        }
        String[] split=s.split(" ");
        StringBuilder output=new StringBuilder();
        for(int i=split.length-1;i>=0;i--){
            if(split[i].length()>0)
                output.append(split[i]+" ");
        }
        output.deleteCharAt(output.length()-1);
        return output.toString();
    }
}
