class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:A[0].toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=1;i<A.length;i++){
            HashMap<Character,Integer> map2=new HashMap<>();
            for(char c:A[i].toCharArray()){
                map2.put(c,map2.getOrDefault(c,0)+1);
            }
            HashMap<Character,Integer> map3=new HashMap<>();
            for(char c:map.keySet()){
                int count=Math.min(map.get(c),map2.getOrDefault(c,0));
                if(count>0){
                    map3.put(c,count);
                }
            }
            map=map3;
        }
        for(char c:map.keySet()){
                int count=map.get(c);
                while(count>0){
                    result.add(String.valueOf(c));
                    count--;
                }
        }
        return result;
    }
}