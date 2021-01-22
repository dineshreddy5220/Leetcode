class UndergroundSystem {
    HashMap<String, Average> map;
    HashMap<Integer, Station> customers;
    public UndergroundSystem() {
        map=new HashMap<>();
        customers=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        customers.put(id, new Station(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Station startStation=customers.get(id);
        Average avg=map.getOrDefault(startStation.name+"_"+stationName,new Average(0,0));
        avg.sum+=t-startStation.time;
        avg.total++;
        map.put(startStation.name+"_"+stationName, avg);
        customers.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
       Average avg=map.get(startStation+"_"+endStation);
        return (avg.sum*1.0)/avg.total;
    }
}
class  Station{
    String name;
    int time;
    public Station(String n,int t){
        name=n;
        time=t;
    }
}
class  Average{
    int sum;
    int total;
    public Average(int s, int t){
        sum=s;
        total=t;
    }
}
​
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
