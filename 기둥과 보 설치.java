import java.util.*;
class Solution {
	boolean[][] Gidong;
	boolean[][] Bo;

	//기둥을 세울 수 있는 경우
	public boolean checkGidong(int x, int y){
		//y가 0인 가장 밑바닥, Gidong이 true면서 기둥 아래.
		//기둥 위는 가능할 때도 있고 불가능할 때도 있음.
		if(y == 0 || Gidong[x][y-1]){
			return true;
		}

		//보 위, 보 끝에
		if((x > 0 && Bo[x-1][y]) || Bo[x][y]){
			return true;
		}

		return false;
	}

	//바를 세울 수 있는 경우
	public boolean checkBo(int x, int y){
		//바 아래 기둥의 경우
		if(Gidong[x][y-1] || Gidong[x+1][y-1]){
			return true;
		}

		//보 위, 보 끝에 (x>0 를 꼭 먼저 해줘야 함.)
		if(x > 0 && Bo[x-1][y] && Bo[x+1][y]){
			return true;
		}

		return false;
	}

	//없앨 수 있는지 확인. -> 영향을 주는 기둥과 보를 생각.
	public boolean delete(int x , int y){
		//x는 음수 불가.
		for(int i=Math.max(x-1, 0); i<=x+1; i++){
			for(int j=y; j<=y+1; j++){
				if(Gidong[i][j] && checkGidong(i, j) == false){
					return false;
				}
				if(Bo[i][j] && checkBo(i, j) == false){
					return false;
				}
			}
		}

		return true;
	}

    public int[][] solution(int n, int[][] build_frame) {
		Gidong = new boolean[n+1][n+1];
		Bo = new boolean[n+1][n+1];
		
		int cnt = 0;
		for(int[] build : build_frame){
			int x = build[0];
			int y = build[1];
			int a = build[2];
			int b = build[3];

			if(a == 0){ //기둥인 경우
				if(b == 1){ //기둥 설치할 경우
					if(checkGidong(x, y)){
						Gidong[x][y] = true; //기둥을 세울 수 있는 곳이라면 true
						cnt++;
					}
				}
				else{ //기둥 삭제
					Gidong[x][y] = false;
					if(delete(x, y) == false){ //기둥 삭제하는데 만약 삭제할 수 없다면
						Gidong[x][y] = true;
					}
					else cnt--;
				}
			}

			else{ //보인 경우
				if(b == 1){
					if(checkBo(x, y)){
						Bo[x][y] = true;
						cnt++;
					}
				}
				else{ // 보 삭제
					Bo[x][y] = false;
					if(delete(x, y) == false){ //보 삭제하는데 만약 삭제할 수 없다면
						Bo[x][y] = true;
					}
					else cnt--;
				}
			}
		}


		//남은 기둥과 보 개수(cnt)를 answer에 넣어야 함
        int[][] answer = new int[cnt][3];

		cnt = 0;
		for(int i=0; i<=n; i++){
			for(int j=0; j<=n; j++){
				if(Gidong[i][j]){
					answer[cnt][0] = i; //x좌표
					answer[cnt][1] = j; //y좌표
					answer[cnt++][2] = 0; //기둥
				}
				if(Bo[i][j]){
					answer[cnt][0] = i;
					answer[cnt][1] = j;
					answer[cnt++][2] = 1;
				}
			}
		}
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(5, new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}})));

		System.out.println(Arrays.toString(T.solution(5, new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},
		{1,1,1,0},{2,2,0,1}})));
	}
}
