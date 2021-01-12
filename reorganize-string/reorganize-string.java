class Solution {
    public String reorganizeString(String S) {
        
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<Character> queue=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char c:S.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        queue.addAll(map.keySet());
        StringBuilder sb=new StringBuilder();
        while(queue.size()>1){
            char top=queue.poll();
            char top2=queue.poll();
            sb.append(top+""+top2);
            if(map.get(top)>1){
                map.put(top,map.get(top)-1);
                queue.offer(top);
            }
            if(map.get(top2)>1){
                map.put(top2,map.get(top2)-1);
                queue.offer(top2);
            }
        }
        if(queue.size()==1){
            char top=queue.poll();
            if(map.get(top)==1)
                sb.append(top);
            else{
                return "";
            }
        }
        return sb.toString();
    }
}
