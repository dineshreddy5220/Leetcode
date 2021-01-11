class Solution {
    public int compress(char[] chars) {
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(char c:chars){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                if(map.size()>0){
                    char key=map.keySet().iterator().next();
                    sb.append(key);
                    if(map.get(key)>1){
                        sb.append(map.get(key));
                    }
                    map.remove(key);
                }
                map.put(c,1);
            }
        }
        if(map.size()>0){
            char key=map.keySet().iterator().next();
            sb.append(key);
            if(map.get(key)>1){
                sb.append(map.get(key));
            }
            map.remove(key);
        }
        for(int i=0;i<sb.length();i++){
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}
