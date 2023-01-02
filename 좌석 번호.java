import java.util.*;
class Solution {
	private static int[] solution(int c, int r, int k){
		int[] answer = new int[2];
		//배열로 생각하기 위해 90도 회전한 상태라 생각하고 시작.
		int[][] map = new int[c][r];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int x = 0, y = 0, cnt = 1, d = 1;

		while(cnt < k){
			int nx = x + dx[d];
			int ny = y + dy[d];

			//이동 가능하면 
			if(nx >= 0 && nx < c && ny >= 0 && ny < r && map[nx][ny] == 0){
				cnt++;
				map[x][y] = cnt;

				//이동 가능하므로 위치 초기화.
				x = nx;
				y = ny;
			}

			//이동 불가능하면 방향 바꾸기.
			else{
				d = (d + 1) % 4;
			}
		}

		answer[0] = x + 1;
		answer[1] = y + 1;

		if(k > c*r) return new int[] {0, 0};
		return answer;
	}

	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(6, 5, 12)));	
		System.out.println(Arrays.toString(solution(6, 5, 20)));
		System.out.println(Arrays.toString(solution(6, 5, 30)));
	}
}

/* 출력
[6, 3]
[2, 3]
[4, 3]
*/
