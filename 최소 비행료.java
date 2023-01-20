import java.util.*;
class Solution {
	//k번 노드를 지나야 한다고 했으므로 다익스트라처럼이지만 bfs로 함.
	//우선순위 큐를 사용하면 순서쌍의 순서가 뒤바껴 레벨 탐색을 못함.
    public int solution(int n, int[][] flights, int s, int e, int k) {
		int answer = 0;
		int INF = 10000000;
		
		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for(int i=0; i<n; i++){
			graph.add(new ArrayList<int[]>());
		}

		int[] costs = new int[n];
		
		Arrays.fill(costs, INF);
		for(int[] x : flights){
			graph.get(x[0]).add(new int[]{x[1], x[2]});
		}
		
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<n; i++){
			costs[i] = INF;
		}

		q.offer(new int[]{s,0});
		costs[0] = 0;
		int L = 0;
		while(!q.isEmpty()){
			int len = q.size();

				for(int i=0; i<len; i++){
					int[] tmp = q.poll();
					int now = tmp[0];
					int nowCost = tmp[1];


				for(int[] x : graph.get(now)){
					int next = x[0];
					int nextCost = x[1];
					if(costs[next] > nowCost + nextCost){
						costs[next] = nowCost + nextCost;
					}
					q.offer(new int[]{next, nowCost + nextCost});
				}
			}
			L++;

			if(L > k){
				break;
			}
		}
		
		
		answer = costs[e];
		if(answer == INF) return -1;


		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(5, new int[][]{
			{0, 1, 10},
			{1, 2, 20},
			{0, 2, 70},
			{0, 3, 100},
			{1, 3, 80},
			{2, 3, 10},
			{2, 4, 30},
			{3, 4, 10}}, 0, 3, 1));


		// System.out.println(T.solution(5, new int[][]{
		// 	{0, 1, 10},
		// 	{0, 2, 10},
		// 	{1, 3, 5},
		// 	{2, 3, 3}}, 0, 3, 0));


		// System.out.println(T.solution(10, new int[][]{
		// 	{1, 8, 50},
		// 	{0, 8, 30},
		// 	{1, 0, 10},
		// 	{2, 8, 10},
		// 	{0, 3, 10},
		// 	{1, 5, 10},
		// 	{1, 7, 100},
		// 	{0, 1, 10}, 
		// 	{0, 2, 10},
		// 	{5, 7, 30},
		// 	{3, 7, 10}, 
		// 	{1, 3, 5}, 
		// 	{2, 3, 3}}, 1, 8, 2));
	}
}


/* 출력
80
-1
30
*/
