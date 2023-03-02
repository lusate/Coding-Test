import java.util.*;
class Solution {
	public int solution(String[] board){
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		int n = board.length;
		int m = board[0].length();

		char[][] chars = new char[n][m];
		int cnt = 0;
		for(int i=0; i<n; i++){ //chars 2차원 배열 새로 생성.
			for(int j=0; j<m; j++){
				char c = board[i].charAt(j);
				chars[i][j] = c;
				if(c >= 97 && c <= 122){
					cnt++;
				}
			}
		}

		int keys = (1 << cnt) - 1;
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visit = new boolean[n][m][keys + 1];
		q.offer(new int[]{0, 0, 0});  //[x 좌표, y 좌표, 열쇠 개수]
		
		visit[0][0][0] = true;
		int L = 0;
		while(!q.isEmpty()){
			int len = q.size();
			for(int i=0; i<len ;i++){
				int[] cur = q.poll();
				
				for(int k=0; k<4; k++){
					int nx = cur[0] + dx[k];
					int ny = cur[1] + dy[k];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m || chars[nx][ny] == '#') continue;
					
					char c = chars[nx][ny];
					int ks = addKey(cur[2], c);
					if(ks == keys) return L+1; //열쇠 다 모으면 최소 거리 반환.

					//c가 대문자인데 열지 못한다면 continue
					if(c >= 65 && c <= 90 && !unlock(cur[2], c)) continue;

					visit[nx][ny][ks] = true;
					q.add(new int[]{nx, ny, ks});
				}
			}

			L++;
		}


		return -1;
    }

	//열쇠 모으는 메서드
	public int addKey(int keys, int c){ //key는 모은 열쇠 개수.
		if(c >= 97 && c <= 122){ //소문자면 소문자 idx를 구하고 or 연산으로 열쇠 모음.
			int idx = c - 97;
			return keys | (1 << idx);
		}

		return keys;
	}

	//대문자로 자물쇠를 열 때 열리면 true
	public boolean unlock(int keys, int c){
		int idx = c - 65;
		return (keys & (1 << idx)) > 0; //& 연산으로 0보다 크면 자물쇠를 열 수 있음.
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"..a.b", "###B#", "..#A.", ".cC..", "....."}));
		System.out.println(T.solution(new String[]{"..a..", "###.#", "b.A.B"}));
		System.out.println(T.solution(new String[]{"...aA", "..B#.", "....b"}));
	}
}



/* 출력
12
8
6
*/
