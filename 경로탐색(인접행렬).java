//경로 탐색(인접행렬) 단점 : 정점 개수가 10000 이상이 되버리면 메모링 망가짐
//갈 수 있는 정점 i를 찾을 때 for문도 10000 이상 돌아야 함 (시간 복잡도도 망가짐)
class Main {
	int target, answer=0;
	int[][] graph;
	int[] ch;
	public void DFS(int v){
		if(v == target) answer++;
		else{
			for(int i=1; i<=target; i++){
				//v = 1 부터
				if(graph[v][i] == 1 && ch[i] == 0){
					ch[i]=1;
					DFS(i);
					ch[i]=0;
				}
			}
		}
	}
	public int solution(int n, int[][] edge){// n: 정점 개수, edge: 인접행렬
		graph = new int[n+1][n+1]; //인접행렬
		ch = new int[n+1];
		target = n; //목표는 정점개수
		for(int[] x : edge){//인접행렬 만들어줌
			graph[x[0]][x[1]] = 1; //방향그래프로 x[0]과 x[1]로만 갈 수 있다.
		} //2차원 배열 graph에서 방문한 부분을 1로 변환함
		ch[1]=1; //??
		DFS(1);
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, 
			{2, 1}, {2, 3}, {2, 5}, {3, 4}, {4, 2}, {4, 5}}));
	}
}
