import java.util.*;
class Edge implements Comparable<Edge>{
    public int vex;
	public int cost;
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}

class Main {
    public int solution(int N, int[][] road, int K){
		int answer=0;
		ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
		for(int i=0; i<=N; i++){
			graph.add(new ArrayList<Edge>());
		}
		int[] dis=new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for(int[] x : road){
			graph.get(x[0]).add(new Edge(x[1], x[2]));
			graph.get(x[1]).add(new Edge(x[0], x[2]));
		}
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(1, 0)); // {도착, 거}
		dis[1]=0;
		while(!pQ.isEmpty()){
			Edge tmp=pQ.poll();
			int now=tmp.vex;
			int nowCost=tmp.cost;
			if(nowCost>dis[now]) continue;
			for(Edge ob : graph.get(now)){
				if(dis[ob.vex]>nowCost+ob.cost){
					dis[ob.vex]=nowCost+ob.cost;
					pQ.offer(new Edge(ob.vex, dis[ob.vex]));
				}
			}
		}
		
		for(int x : dis){
			if(x <= K) {
				answer++;
			}
		}
		return answer;
    }

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, 
			{5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
		
		System.out.println(T.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, 
			{2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
	}
}

/* 출력 
4
4
*/


//현재 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 합니다. 
//각 마을로부터 음식 주문을 받으려고 하는데, N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 합니다


// ------------------------------------------------------------------------------------------------------------


// 플로이드 와샬로 풀이
import java.util.*;
class Solution{
    public int solution(int N, int[][] road, int K) {
        int[][] map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue; //기존에 플로이드 할 때는 여기를 0으로 초기화를 했는데 에러남. (이유는 모르겠음.)
                }
                map[i][j] = 1000000;
            }
        }

        for (int[] x : road) {
            if(map[x[0]][x[1]] < x[2])  continue;   //원래 있는 길이 더 적은 길이면 무시.
            map[x[0]][x[1]] = x[2];
            map[x[1]][x[0]] = x[2];
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (map[1][i] <= K)
                count++;
        }

        return count;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3},
                {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));

        System.out.println(T.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2},
                {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }
}
