import java.util.*;
public class Main {
	static int N,M,H, answer;
	static int[][] map;
	static boolean flag = false;
	
	private static boolean check(){ //i에서 시작해서 i로 오는지 확인.
		for(int i=1; i<=N; i++){
			int x = 1; //x는 항상 1부터 시작.
			int y = i;
			for(int j=0; j<H; j++){
				if(map[x][y] == 1) y++; //1이면 오른쪽 이동
				else if(map[x][y] == 2) y--; //2면 왼쪽 이동
				x++; //이동하고 나면 한 칸 내려와야 함.
			}
			if(y != i){
				return false;
			}
		}
		return true;
	}
	private static void dfs(int x, int cnt) { //cnt는 사다리 개수로 하나씩 늘려가면서 체크함.
		if (flag) return; // i 가 사다리 타고 갔을 때 i가 아님.
        if(answer == cnt){
			if(check()){
				flag = true;
				return;
			}
		}
		for(int i=x; i<=H; i++){
			for(int j=1; j<N; j++){
				//왼쪽 0, 오른쪽 0 이면 1,2 로 설정해줌. -> 사다리 추가.
				if(map[i][j] == 0 && map[i][j+1] == 0){
					map[i][j] = 1;
					map[i][j+1] = 2;
					dfs(i, cnt+1); //map에서 사다리 1개를 추가하는 경우, 2개를 추가하는 경우~~ 를 모두 탐색해본다.
					map[i][j] = 0; //dfs 끝나면 뒤로 빽해서 다시 초기화.
					map[i][j+1] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //세로 선 개수
		M = sc.nextInt(); //입력한 가로 선 개수
		H = sc.nextInt(); //세로선마다 가로선을 놓을 수 있는 위치의 개수
		map = new int[H+1][N+1];

		for(int i=0; i<M; i++){
			int x = sc.nextInt(); // a
			int y = sc.nextInt(); // b

			//1이면 왼쪽 2면 오른쪽 나머지는 0으로 설정.
			map[x][y] = 1;
			map[x][y+1] = 2;
		}
		// 세로 선 b 와 b+1을 잇는 선으로 a에서 시작.

		for(int i=0; i<=3; i++){
			answer = i; //answer는 3보다 커지면 안됨.
			dfs(1, 0); // 1은 시작점, 0은 사다리 개수 0부터 시작.
			if(flag) break;
		}
		//i 가 1 일 때 사다리 추가한 개수가 한 개이다. 사다리 한 개 추가했을 때 dfs() 돌려서 flag가 true면 answer = 1 아니면 answer = 2로 해서 다시.

		System.out.println((flag) ? answer : -1);
	}
}


/* 입력
2 0 3


5 5 6
1 1
3 2
2 3
5 1
5 4
*/


/* 출력
0

3
*/
