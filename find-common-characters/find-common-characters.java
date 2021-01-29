class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result=new ArrayList<>();
        int[] map=new int[26];
        for(char c:A[0].toCharArray()){
            map[c-'a']++;
        }
        for(int i=1;i<A.length;i++){
            int[] map2=new int[26];
            for(char c:A[i].toCharArray()){
                map2[c-'a']++;
            }
            for(int j=0;j<26;j++){
                map[j]=Math.min(map[j],map2[j]);
            }
        }
        for(int j=0;j<26;j++){
            int count=map[j];
            while(count>0){
                char c='a';
                c+=j;
                result.add(String.valueOf(c));
                count--;
            }
        }
        return result;
    }
}