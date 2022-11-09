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
