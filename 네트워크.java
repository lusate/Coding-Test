import java.util.*;
class Main {
	public void DFS(int v, 	boolean[] visited, int[][] computers){
		visited[v] = true;
		for(int i=0; i<computers.length; i++){
			if(visited[i] == false && computers[v][i] == 1){
				DFS(i, visited, computers);
			}
		}
	}
	public int solution(int n, int[][] computers) {
		int answer=0;
		boolean[] visited = new boolean[computers.length];

		for(int i=0; i<computers.length; i++){
			visited[i] = false;
		}
		for(int i=0; i<computers.length; i++){
			if(visited[i] == false){
				answer++;
				DFS(i, visited, computers);
			}
		}
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
	}
}
