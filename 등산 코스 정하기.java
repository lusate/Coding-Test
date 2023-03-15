import java.util.*;
class Solution {
	//num이 현재 출발점이 맞는지 확인
	public boolean isGate(int num, int[] gates){
		for(int x : gates){
			if(num == x) return true;
		}

		return false;
	}

	//num이 현재 산봉우리가 맞는지 확인
	public boolean isSummit(int num, int[] summits){
		for(int x : summits){
			if(num == x) return true;
		}

		return false;
	}

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		int[] answer = new int[2];
		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for(int i=0; i<n+1; i++){ //양방향이므로 +1 해줌
			graph.add(new ArrayList<>());
		}

		for(int[] x : paths){
			// 출입구일 경우 다른 곳으로만 갈 수 있는 단방향
			// 산봉우리일 경우 특정 한 곳에서 산봉우리로 가는 단방향
			// 출발점에서 출발하고 난 후 돌아올 때는 
			if(isGate(x[0], gates) || isSummit(x[1], summits)){
				graph.get(x[0]).add(new int[]{x[1], x[2]});
			}

			else if(isGate(x[1], gates) || isSummit(x[0], summits)){
				graph.get(x[1]).add(new int[]{x[0], x[2]});
			}
			else{
				graph.get(x[0]).add(new int[]{x[1], x[2]});
				graph.get(x[1]).add(new int[]{x[0], x[2]});
			}
		}

		Queue<int[]> q = new LinkedList<>();
		int[] cost = new int[n+1];
		Arrays.fill(cost, Integer.MAX_VALUE);

		for(int x : gates){
			q.offer(new int[]{x, 0});
			cost[x] = 0;
		}

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int now = cur[0];
			int nowCost = cur[1];
			// 현재의 가중치가 저장된 가중치보다 커서 최소 갱신이 되지 않으면 continue
			if(nowCost > cost[now]) continue;
			// System.out.println("size : " + graph.get(now).size());

			for(int i=0; i<graph.get(now).size(); i++){
				int[] tmp = graph.get(now).get(i);  //[도착 지점, 걸리는 시간]
				// System.out.println("d : " + Arrays.toString(tmp));
				
				// itensity는 휴식 없이 이동해야 하는 시간 중 가장 긴 시간.
				int dis = Math.max(cost[now], tmp[1]); // 
				if(cost[tmp[0]] > dis){ //다음 노드로 이동할 때 걸리는 시간이 itensity보다 더 크면
					cost[tmp[0]] = dis;
					q.offer(new int[]{tmp[0], dis});
				}
			}
			// 같은 결과
// 			for(int[] x : graph.get(now)){
// 				int dis = Math.max(cost[now], x[1]);
// 				if(cost[x[0]] > dis){
// 					cost[x[0]] = dis;
// 					q.offer(new int[]{x[0], dis});
// 				}
// 			}
			
			
		}

		//입구에서 정상까지 가는 경로가 최소이면 돌아오는 경로도 똑같이 최소인 경로로 돌아오면 되므로 
	    	//입구에서 산봉우리까지 가는 경우의 경로만 생각하면 된다.
		

	    	// 이 itensity 중에서의 최소값을 구해야 함.
		Arrays.sort(summits);
		Arrays.fill(answer, Integer.MAX_VALUE);
		for(int x : summits){
			if(cost[x] < answer[1]){
				answer[0] = x;
				answer[1] = cost[x];
			}
		}

        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, 
		{3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}, new int[]{1, 3}, new int[]{5})));

		// System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 4, 4}, {1, 6, 1}, 
		// {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[]{1}, new int[]{2, 3, 4})));

		// System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, 
		// {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[]{3, 7}, new int[]{1, 5})));

		// System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3, 10}, {1, 4, 20}, {2, 3, 4}, 
		// {2, 4, 6}, {3, 5, 20}, {4, 5, 6}}, new int[]{1, 2}, new int[]{5})));
	}
}


/* 출력
[5, 3]
[3, 4]
[5, 1]
[5, 6]
*/


// 문제 핵심
// 출입구에 연결된 양방향 등산로 -> 출입구에서 다른 지점으로만 이동 가능한 단방향 등산로.
// 산봉우리 연결된 양방향 등산로 -> 다른 지점에서 산봉우리로만 이동 가능한 단방향 등산로.
// 별다른 중복처리 없이 등산코스에서 출입구는 처음과 끝에 한 번씩, 산봉우리는 한 번만 포함되어야 하는 규칙을 지킬 수 있다.
