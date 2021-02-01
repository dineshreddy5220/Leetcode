class Leaderboard {
    Map<Integer,Player> players = new HashMap();
    TreeSet<Player> scores = new TreeSet<Player>((a,b)->{
        return b.score-a.score==0?a.id-b.id:b.score-a.score;
        });
    public Leaderboard() {
        
    }
    
    //Log(N)
    public void addScore(int playerId, int score) {
        Player cur;
        if(players.containsKey(playerId)){
            cur = players.get(playerId);
            scores.remove(cur);
            cur.score+=score;
            scores.add(cur);
        }else{
            cur = new Player(playerId,score);
            players.put(playerId,cur);
            scores.add(cur);
        }        
    }
    
    //O(K)
    public int top(int K) {
        Iterator<Player> iterator = scores.iterator();
        int res = 0;
        while(K-->0&&iterator.hasNext()){
            res += iterator.next().score;
        }
        return res;
    }
    
    //O(logN)
    public void reset(int playerId) {
        Player cur = players.get(playerId);
        scores.remove(cur);
        cur.score = 0;
    }
    class Player{
        int id;
        int score;
        public Player(int id, int score){
            this.id = id;
            this.score = score;
        }
    }
}