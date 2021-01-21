class Solution {
    List<List<String>> output;
    HashMap<String,Boolean> palindromes;
    public List<List<String>> partition(String s) {
        output=new ArrayList<>();
        palindromes=new HashMap<>();
        if(s.length()==0){
            return output;
        }
        recursion(s,new ArrayList<>(),0);
        return output;
    }
    public void recursion(String s, List<String> list, int start){
        if(start==s.length()){
            output.add(new ArrayList(list));
            return;
        }
        for(int i=start+1;i<=s.length();i++){
            String subString=s.substring(start,i);
            if(isPalindrome(subString)){
                list.add(subString);
                recursion(s,list,i);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        if(palindromes.containsKey(s)){
            return palindromes.get(s);
        }
        int i=0;
        int j=s.length()-1;
        while(i<j){
           if(s.charAt(i)!=s.charAt(j)){
               palindromes.put(s,false);
               return false;
           } 
            i++;
            j--;
        }
        palindromes.put(s,true);
        return true;
    }
    
}
