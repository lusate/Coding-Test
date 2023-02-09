import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> graph;
    int[] infos;
    int maxSheep;
    public void dfs(int sheep, int wolf, int now, boolean[] visit){
        if(infos[now] == 0) sheep++;
        else if(infos[now] == 1) wolf++;
        
        if(wolf >= sheep) return;
        //visited가 false면 dfs 재귀를 하고나서 visited를 초기화하기 위함.
        //즉 다음 노드로 이동하고 나서 이전 노드로 다시 돌아올 수 있기 때문.
        boolean[] visited = visit.clone();
        visited[now] = true;
        
        maxSheep = Math.max(maxSheep, sheep);
        
        for(int i=0; i<visited.length; i++){
            if(visited[i] == true){
                for(int j=0; j<graph.get(i).size(); j++){
                    //grpah의 도착 노드들
                    int tmp = graph.get(i).get(j);
                    
                    //도착 노드들을 방문하지 않았다면 dfs
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
    int maxSheep;
    public void dfs(int sheep, int wolf, int now, int[] info){
        if(infos[now] == 0) sheep++;
        else if(infos[now] == 1) wolf++;
        
        if(wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);
        
        for(int i=0; i<graph[now].size(); i++){
			int next = graph[now].get(i);
			int tmp = info[now];
			if(!visit[next][sheep][wolf]){
				info[now] = -1; //방문하지 않으면 양도 아니고 늑대도 아닌 -1
				visit[now][sheep][wolf] = true;
				dfs(sheep, wolf, next, info);
				info[now] = tmp;
				visit[now][sheep][wolf] = false;
			}
		}
        
    }
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        int n = info.length;
        maxSheep = 0;
        
        //int[] 안에 ArrayList가 있음.
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
        //graph를 이중 ArrayList가 아닌 배열로 함.
        
        visit = new boolean[n][n+1][n+1];
        dfs(0,0,0, info);
        answer = maxSheep;
        
        return answer;
    }
}
