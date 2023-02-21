import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> graph;
    int maxSheep;
    public void dfs(int now, int sheep, int wolf, boolean[] visit, int[] info){
        if(info[now] == 0) sheep++;
        else if(info[now] == 1) wolf++;
        if(sheep <= wolf) return;
        
	//visited가 false면 dfs 재귀를 하고나서 visited를 초기화하기 위함.
        //즉 다음 노드로 이동하고 나서 이전 노드로 다시 돌아올 수 있기 때문.
        boolean[] visited = visit.clone();
        visited[now] = true;
        maxSheep = Math.max(maxSheep, sheep);
        
        for(int i=0; i<visited.length; i++){
            if(visited[i] == true){
                for(int j=0; j<graph.get(i).size(); j++){
                    int tmp = graph.get(i).get(j);
                    
                    if(visited[tmp] == false){
                        dfs(tmp, sheep, wolf, visited, info);
                    }
                }
            }
        }
        
    }
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        graph = new ArrayList<>();
        int n = info.length;
        boolean[] visit = new boolean[n];
        maxSheep = 0;
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dfs(0,0,0,visit,info);
        
        answer = maxSheep;
        return answer;
    }
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, 
        new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, 
        {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}));

        System.out.println(T.solution(new int[]{0,1,0,1,1,0,1,0,0,1,0},
        new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}));
	}
}


-------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;
class Solution {
    ArrayList<Integer>[] graph;
    boolean[][][] visit;
    int maxSheep;
    public void dfs(int sheep, int wolf, int now, int[] info){
        if(info[now] == 0) sheep++;
        else if(info[now] == 1) wolf++;
        
        if(wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);
        
        for(int i=0; i<graph[now].size(); i++){ //i는 0 ~ 2까지
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
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, 
        new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, 
        {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}));

        System.out.println(T.solution(new int[]{0,1,0,1,1,0,1,0,0,1,0},
        new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}}));
	}
}
