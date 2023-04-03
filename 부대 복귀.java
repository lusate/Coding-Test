import java.util.*;
class Solution {
	int INF = 100000;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] x : roads){
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        
        int[] cost = new int[n+1];
        Arrays.fill(cost, INF);
        // cost[1] = 0;
        
        //source에서 출발
        Queue<Integer> q = new LinkedList<>();
		//출발한 곳에서 최단 거리를 구해줘야 하므로 q에 destination을 삽입.
        q.offer(destination);
        cost[destination] = 0;
	    //그렇지 않으면 계속 목적지의 거리만 최소 거리를 갱신함.

        while(!q.isEmpty()){
            int cur = q.poll();

//             for(int t=0; t<graph.get(cur).size(); t++){
//                 int tmp = graph.get(cur).get(t); //도착 정점
//                 // System.out.println(tmp);

//                 if(cost[tmp] > cost[cur] + 1){
//                     cost[tmp] = cost[cur] + 1;
//                     q.offer(tmp);
//                 }
//             }
		
	    for(int t : graph.get(cur)){
                if(cost[t] > cost[cur] + 1){
                    cost[t] = cost[cur] + 1;
                    q.offer(t);
                }
            }
        }
        
        
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            if(cost[sources[i]] < INF){
                answer[i] = cost[sources[i]];
            }
            else answer[i] = -1;
        }
        
        //answer는 [sources에서 출발해서 도착할 때 최단 거리들]
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1)));

		System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4},
		{2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5)));
	}
}


/* 출력
[1, 2]
[2, -1, 0]
*/
