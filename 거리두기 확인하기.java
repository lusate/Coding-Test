import java.util.*;
class Solution{
    int n;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visit;

    public int Correct(String[] str){
        n = str.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(str[i].charAt(j) == 'P'){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visit = new boolean[n][n];
                    visit[i][j] = true;

                    while(!q.isEmpty()){
                        int[] tmp = q.poll();

                        for(int k=0; k<4; k++){
                            int nx = tmp[0] + dx[k];
                            int ny = tmp[1] + dy[k];
                            int manhatten = Math.abs(i - nx) + Math.abs(j - ny);

                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

				            if(visit[nx][ny] || manhatten > 2) continue;

                            visit[nx][ny] = true;
                            if(str[nx].charAt(ny) == 'X') continue;
                            if(str[nx].charAt(ny) == 'P') return 0;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return 1;
    }
	public int[] solution(String[][] places) {
		n = places.length;
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            answer[i] = Correct(places[i]);

        }

        return answer;
    }
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
		{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
		
	}
}


-------------------------------------------------------------------------------------------------------------------

import java.util.*;
class Solution{
	int n;
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	boolean[][] visit;

	//거리두기 지켰는지 확인.
	public boolean bfs(int x, int y, String[] str){
		int n = str.length;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x,y});
		visit = new boolean[n][n];
		visit[x][y] = true;
		
		while(!q.isEmpty()){
			int[] tmp = q.poll();

			for(int i=0; i<4; i++){
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				int manhatten = Math.abs(x - nx) + Math.abs(y - ny);

				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

				if(visit[nx][ny] || manhatten > 2) continue;

				visit[nx][ny] = true;
				
				if(str[nx].charAt(ny) == 'X') continue;
				if(str[nx].charAt(ny) == 'P') return false;
				q.offer(new int[]{nx, ny});
			}
		}

		return true;
	}

	//확인 한 것을 숫자 1, 0으로 반환.
	public int Correct(String[] str){
		int n = str.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(str[i].charAt(j) == 'P'){ //현재 위치 P
					if(!bfs(i, j, str)) return 0; //거리두기가 지켜지지 않은 경우.
				}
			}
		}

		return 1;
	}


	public int[] solution(String[][] places) {
		n = places.length;
		int[] answer = new int[n];
		
		for(int i=0; i<n; i++){
			answer[i] = Correct(places[i]);
		}

		return answer;
    }
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
		{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
		
	}
}

/* 출력
[1, 0, 1, 1, 1]
*/
