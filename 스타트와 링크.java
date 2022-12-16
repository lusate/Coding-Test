import java.util.*;
public class Main {
	static int N;
	static int[][] map;
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;
 
	static void dfs(int cnt, int idx) {
		if(cnt == N / 2) {
			int startAbility = 0; //start 팀 능력치
			int linkAbility = 0; //link 팀 능력치
 
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visit[i] == true && visit[j] == true) {
						startAbility += map[i][j] + map[j][i];
					}

					else if (visit[i] == false && visit[j] == false) {
						linkAbility += map[i][j] + map[j][i];
					}
				}
			}
			int diff = Math.abs(startAbility - linkAbility); //능력치 차
		

			if (diff == 0) { //0 이 나오면 더 이상 최솟값 찾을 필요가 없음.
				System.out.println(diff);
				System.exit(0);
			}
		
			result = Math.min(diff, result);
			return;
		}
 

		for(int i = idx; i < N; i++) {
				// 방문하지 않았다면?
			if(!visit[i]) {
				visit[i] = true;	// 방문으로 변경
				dfs(cnt + 1, i + 1);	// 재귀 호출
				visit[i] = false;	// 재귀가 끝나면 비방문으로 변경
			}
		}
	}
 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
 
		map = new int[N][N];
		visit = new boolean[N];
 
 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
 
		dfs(0, 0);
		System.out.println(result);
	}
}


/* 입력
4
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0
*/


/* 출력
0
*/
