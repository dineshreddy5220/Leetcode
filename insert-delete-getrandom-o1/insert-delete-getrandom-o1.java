class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer,Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
        rand=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        else{
            map.put(val,list.size());
            list.add(val);
            return true;
        }
    }
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index=map.get(val);
            int lastVal=list.get(list.size()-1);
            list.set(index,lastVal);
            list.remove(list.size()-1);
            map.put(lastVal,index);
            map.remove(val);
            return true;
        }
        else{
            return false;
        }
    }
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
