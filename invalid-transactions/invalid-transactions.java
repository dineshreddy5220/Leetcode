class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        ArrayList<String> invalid=new ArrayList<>();
        HashMap<String, HashSet<Node>> map=new HashMap<>();
        for(String transaction:transactions){
            String split[] =transaction.split(",");
            int amount=Integer.parseInt(split[2]);
            boolean flag=false;
            if(amount>1000){
                flag=true;
            }
            if(map.containsKey(split[0])){
                int time=Integer.parseInt(split[1]);
                for(Node node:map.get(split[0])){
                    if(Math.abs(node.time-time)<=60 && !node.city.equals(split[3])){
                        if(node.invalid==false){
                            invalid.add(node.transaction);
                            node.invalid=true;
                        }
                        flag=true;
                    }
                }
                HashSet<Node> set=map.getOrDefault(split[0],new HashSet<>());
                set.add(new Node(split[0],Integer.parseInt(split[1]),amount,split[3],transaction, flag));
                map.put(split[0],set);
            }
            else{
                HashSet<Node> set=new HashSet<>();
                set.add(new Node(split[0],Integer.parseInt(split[1]),amount,split[3],transaction, flag));
                map.put(split[0],set);
            }
            if(flag){
                invalid.add(transaction);
            }
        }
        return invalid;
    }
}
class Node{
    String name;
    int time;
    int amount;
    String city;
    String transaction;
    boolean invalid;
    public Node(String n, int t, int a, String c, String trans,boolean invalid){
        name=n;
        time=t;
        amount=a;
        city=c;
        transaction=trans;
        this.invalid=invalid;
    }
}