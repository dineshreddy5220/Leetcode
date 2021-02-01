class Solution {
    List<List<Integer>> output;
    int[] visited;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       output=new ArrayList<>();
        visited=new int[graph.length];
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        dfs(graph, list, 0, graph.length-1);
        return output;
    }
    public void dfs(int[][] graph, ArrayList<Integer> list, int start, int end){
        if(start==end){
            output.add(new ArrayList<>(list));
            return;
        }
        visited[start]=1;
        for(int edge:graph[start]){
            if(visited[edge]==0){
                list.add(edge);
                dfs(graph,list,edge,end);
                list.remove(list.size()-1);
            }
        }
        visited[start]=0;
    }
}