import java.util.*;
class Main {
	public void bfs(int n, int k){
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(n);
		int[] visited = new int[100001];
		visited[n] = 1;
		int L = 0;
		if(n == k){
			System.out.println(0);
			System.exit(0);
		}
		while(!Q.isEmpty()){
			int len = Q.size();
			for(int i=0; i<len; i++){
				int x = Q.poll();
				for(int nx : new int[]{x-1, x+1, x*2}){
					if(nx == k){
						System.out.println(L+1);
						System.exit(0);
					}
					if(nx >= 0 && nx < 100001 && visited[nx] == 0){
						visited[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
	}
	public static void main(String[] args) throws Exception {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수빈 위치
		int k = sc.nextInt(); //동생 위치
		
		T.bfs(n, k);
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
class Main{
	public int solution(int n, int k){
		Queue<Integer> Q = new LinkedList<>();
		int[] ch = new int[100001];
		Q.offer(n);
		ch[n] = 1;
		int L = 0;
		if(n == k){
			return 0;
		}
		while(!Q.isEmpty()){
			int len = Q.size();
			for(int i=0; i<len; i++){
				int v = Q.poll();
				for(int nv : new int[]{v-1, v+1, v*2}){
					if(nv == k) return L+1;
					if(nv >= 0 && nv < 100001 && ch[nv] == 0){
						ch[nv] = 1;
						Q.offer(nv);
					}
				}
			}
			L++;
		}
		
		return 0;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //수빈 위치
		int k = sc.nextInt(); //동생 위치
		
		System.out.println(T.solution(n, k));
	}
}

/* 입력
5 17
*/

/* 출력
4
*/
