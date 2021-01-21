class Solution {
    List<List<String>> output;
    public List<List<String>> partition(String s) {
        output=new ArrayList<>();
        backtrack(s,0,new ArrayList<>());
        return output;
    }
    public void backtrack(String s, int start, ArrayList<String> list){
        if(start>=s.length()){
            output.add( new ArrayList<>(list));
            return;
        }
        for(int i=start+1;i<=s.length();i++){
            if(isPalindrome(s.substring(start,i))){
                list.add(s.substring(start,i));
                backtrack(s, i,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        return s.equals((new StringBuilder(s)).reverse().toString());
    }
}
