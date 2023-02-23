import java.util.*;
class Solution{
	int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; 
	public int solution(int[] key, String password){
		int answer = 0;

		int[][] map = new int[3][3];
		int[][] dist = new int[10][10];

		//키패드 삽입 완성
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				map[i][j] = key[i*3+j];
			}
		}


		//dist[10][10]를 모두 2로 초기화.
		for(int i = 0; i < 10; i++){
			Arrays.fill(dist[i], 2);
		}

		//자기 자신의 번호로 가는 시간은 0
		for(int i=0; i<10; i++){
			dist[i][i] = 0;
		}


		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				//start 시작
				int start = map[i][j];

				//end로 이동. dist 완료.
				for(int d=0; d<8; d++){
					int nx = i + dx[d];
					int ny = j + dy[d];
					if(nx>=0 && nx<3 && ny>=0 && ny<3){
						int end = map[nx][ny];
						dist[start][end] = 1;
					}
				}
			}
		}

		//여기서 탐색하면서 password
		for(int k=0; k<password.length()-1; k++){
			int start = (int)password.charAt(k)-48; //55 - 48
			int end = (int)password.charAt(k+1)-48;
			answer += dist[start][end];
		}

		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));	
		System.out.println(solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
	}
}


/* 출력
8
12
13
8
*/
