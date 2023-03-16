import java.util.*;
class Solution {
	int INF = Integer.MAX_VALUE;
	int N;
	int answer;
	public void dfs(int cnt, int pos, int visit, int[] weak, int[] dist){
		if(cnt > dist.length) return; //모든 친구 사용 수 넘어가면 종료.
		//가지치기.
		if(cnt >= answer) return; //cnt 늘려가면서 dfs 하다가 최소값이 나오면 더 이상 진행 필요없음.

		for(int i=0; i<weak.length; i++){
			// int next = pos + i; //취약점들 위치 인덱스
			int next = (pos + i) % weak.length; //11 다음에 1로 갈 수 있기 때문 %
			int dis = weak[next] - weak[pos]; //거리

			//한 바퀴 돌아서 0을 지남.  //반시계도 생각.
			if(next < pos) dis = N + weak[next] - weak[pos];


			//dist 가장 긴 것부터 사용.  dis가 더 길면 사용 불가.
			if(dis > dist[dist.length - cnt]) break;
			
			//방문 표시. (방문 표시한 것을 모으기 위함.)
			visit = (visit | (1 << next));
		}


		//모든 취약점을 방문했는지 확인.
		//취약점 개수만큼의 비트가 다 1로 켜짐. 그래서 -1함.
		if(visit == (1 << weak.length) - 1){
			answer = cnt;  // Math.min(answer, cnt);
			return;
		}

		//아직 방문하지 않은 취약점이 있다고 하면
		for(int i=0; i<weak.length; i++){
			if((visit & (1 << i)) != 0) continue;
			//0이면 방문하지 않음, 0이 아니면 이미 방문함

			dfs(cnt+1, i, visit, weak, dist);
			//dfs(사용할 친구 명수, 취약점 위치 인덱스, 취약점 방문 여부)
		}
	}

    public int solution(int n, int[] weak, int[] dist) {
		N = n;
		answer = INF;

		for(int i=0; i<weak.length; i++){
			dfs(1, i, 0, weak, dist);
			//비트가 0면 방문한 곳이 없는 것.
		}

		if(answer == INF) return -1;

		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(12, new int[]{1,5,6,10}, new int[]{1,2,3,4}));
		System.out.println(T.solution(12, new int[]{1,3,4,9,10}, new int[]{3,5,7}));
	}
}


/* 출력
2
1
*/
