import java.util.*;
class Main{
	static int min = Integer.MAX_VALUE;
	static int cnt = 0;
	static int n,k;

	private static void bfs(){
		Queue<Integer> Q = new LinkedList<>();
		int[] ch = new int[100001];

		Q.offer(n);
		ch[n] = 1;

		while(!Q.isEmpty()){
			int v = Q.poll();
			if(min < ch[v]) return;

			for(int nv : new int[]{v-1, v+1, v*2}){
				if(nv >= 0 && nv < 100001) {
					if(nv == k){
						min = ch[v];
						cnt++;
					}
					else{
						if(ch[nv] == 0 || ch[nv] == ch[v] + 1){
							Q.offer(nv);
							ch[nv] = ch[v] + 1;
						}
					}
				}
				
				
			}
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		if(n >= k){
			System.out.println(n - k);
			System.out.println(1);
			return;
		}
		
		bfs();
		System.out.println(min);
		System.out.println(cnt);
	}
}

/* 입력
5 17


4 5


10000 10026
*/

/* 출력
4
2


1
1


26
1
*/
