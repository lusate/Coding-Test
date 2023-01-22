import java.util.*;
class Main{
	private static int solution(int s, int e){
		int[][] ch = new int[2][200001];
		Queue<Integer> Q = new LinkedList<>();
		ch[0][s] = 1; //짝수 체크
		ch[1][s] = 1; //홀수 체크

		Q.offer(s);
		int L=0;
		while(!Q.isEmpty()){
			int len = Q.size();
			L++;
			for(int d=0; d<len; d++){
				int x = Q.poll();
				for(int nx : new int[]{x-1, x+1, x*2}){
					if(nx>=0 && nx<=200000 && ch[L%2][nx] == 0){
						ch[L%2][nx] = 1;
						Q.offer(nx);
					}
				}
			}
			//L++; 여기 있어도 됨.
			e += L;
			if(e > 200000) return -1;
			if(ch[L%2][e] == 1) return L;
		}

		
		
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println(solution(1, 11));
		// System.out.println(solution(10, 3));
		// System.out.println(solution(1, 34567));
	}
}



/* 출력
6
3
19
*/
