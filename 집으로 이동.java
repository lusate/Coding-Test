import java.util.*;
class Main{
	public int solution(int[] pool, int a, int b, int home){
		int[][] ch = new int[2][10001];
		for(int x : pool){
			ch[0][x] = 1;
			ch[1][x] = 1;
		}

		Queue<int[]> Q = new LinkedList<>();
		ch[0][0] = 1; //a이동 체크
		ch[1][0] = 1; //b이동 체크
		Q.offer(new int[]{0,0});
		
		int L = 0;
		while(!Q.isEmpty()){
			int len = Q.size();
			for(int d=0; d<len; d++){
				int[] tmp = Q.poll();
				if(tmp[0] == home) return L;
				// System.out.println(Arrays.toString(tmp));
				
				int nx = tmp[0] + a;
				if(nx <= 10001 && ch[0][nx] == 0){// 0부터 시작해서 +이므로 nx>=0은 필요없음
					ch[0][nx] = 1; //이동하면 체크
					Q.offer(new int[]{nx, 0});
				}

				nx = tmp[0] - b;
				if(nx>=0 && ch[1][nx] == 0 && tmp[1] == 0){ // -이므로 0보다 크도록 설정. (음수되지 않게) 반대로 nx>=10001 필요없음.
					ch[1][nx] = 1;
					Q.offer(new int[]{nx, 1});
				}
			}
			L++;
		}
		return -1;

	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{11,7,20}, 3, 2, 10));
		System.out.println(T.solution(new int[]{1,15,11}, 3, 2, 5));
		System.out.println(T.solution(new int[]{9,15,35,30,20}, 2, 1, 25));
		System.out.println(T.solution(new int[]{5,12,7,19,23}, 3, 5, 18));
	}
}



/* 출력
5
5
14
-1
*/
