import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> graph;
    int[] infos;
    int maxSheep;
    public void dfs(int sheep, int wolf, int now, boolean[] visit){
        if(infos[now] == 0) sheep++;
        else if(infos[now] == 1) wolf++;
        
        if(wolf >= sheep) return;
        boolean[] visited = visit.clone();
        visited[now] = true;
        
        maxSheep = Math.max(maxSheep, sheep);
        
        for(int i=0; i<visited.length; i++){
            if(visited[i] == true){
                for(int j=0; j<graph.get(i).size(); j++){
                    int tmp = graph.get(i).get(j);
                    
                    if(visited[tmp] == false){
                        dfs(sheep, wolf, tmp, visited);
                    }
                }
            }
        }
        
    }
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        int n = info.length;
        graph = new ArrayList<>();
        boolean[] visit = new boolean[n];
        maxSheep = 0;
        
        infos = info;
        for(int i=0; i<info.length; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println(graph);
        
        dfs(0,0,0, visit);
        answer = maxSheep;
        
        return answer;
    }
}


-------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;
class Solution {
    ArrayList<Integer>[] graph;
    boolean[][][] visit;
    int[] infos;
    int maxSheep;
    public void dfs(int sheep, int wolf, int now){
        if(infos[now] == 0) sheep++;
        else if(infos[now] == 1) wolf++;
        
        if(wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);
        
        for(int i=0; i<graph[now].size(); i++){
            int next = graph[now].get(i);
            int tmp = infos[now];
            if(!visit[next][sheep][wolf]){
                infos[now] = -1;
                visit[now][sheep][wolf] = true;
                dfs(sheep, wolf, next);
                infos[now] = tmp;
                visit[now][sheep][wolf] = false;
            }
        }
        
    }
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        int n = info.length;
        maxSheep = 0;
        infos = info;
        
        graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        visit = new boolean[n][n+1][n+1];
        dfs(0,0,0);
        answer = maxSheep;
        
        return answer;
    }
}
