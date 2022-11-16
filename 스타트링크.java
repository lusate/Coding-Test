import java.util.*;
class Main {
	static int F, S, G, U, D;
	static int visited[];
	static void bfs(int F, int S, int G, int U, int D) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(S);
		visited[S] = 1;
		
		while(!Q.isEmpty()) {
			int tmp = Q.poll();
			if(tmp == G) { //도착한 경우
				System.out.println(visited[tmp] - 1);
				break;
			}
			if(tmp + U <= F && visited[tmp+U] == 0) {
				//범위 지정, 방문하지 않음
				visited[tmp+U] = visited[tmp] + 1;
				Q.offer(tmp+U);
			}
			if(tmp - D > 0 && visited[tmp-D] == 0) {
				//범위 지정, 방문하지 않음
				visited[tmp-D] = visited[tmp] + 1;
				Q.offer(tmp-D);
			}
		}
		if(visited[G] == 0) {
			System.out.println("use the stairs");
		}
	}
	public static void main(String[] args) throws Exception{
		Main T = new Main();
		Scanner sc = new Scanner(System.in);	
		F = sc.nextInt(); //총 층수
		S = sc.nextInt(); //강호 위치
		G = sc.nextInt(); //목적지
		U = sc.nextInt(); //올라갈 층 수
		D = sc.nextInt(); //내려갈 층 수
		visited = new int[F+1];
		
		T.bfs(F, S, G, U, D);
	}
}

/* 입력
10 1 10 2 1
*/

/* 출력
6
*/
