class Solution {
    public String decodeString(String s) {
        Stack<Integer> numbers=new Stack<>();
        Stack<String> alphabets=new Stack<>();
        int num=0;
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num=num*10+Character.getNumericValue(c);
            }
            else if(c=='['){
                alphabets.push(sb.toString());
                sb=new StringBuilder();
                numbers.push(num);
                num=0;
            }
            else if(c==']'){
                int k=numbers.pop();
                String content=sb.toString();
                if(alphabets.size()>0){
                    sb.insert(0,alphabets.pop());
                }
                for(int i=1;i<k;i++){
                    sb.append(content);
                }
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}