import java.util.*;
class Main {
	public int solution(int s, int e){
		//s는 현수 위치, e는 송아지 위치
		Queue<Integer> Q = new LinkedList<>();
		//직선의 좌표 점은 1부터 10,000까지이다
		int[] ch = new int[10001]; //체크 배열
		Q.offer(s);
		ch[s] = 1;
		int L=0;
		while(!Q.isEmpty()){ //레벨 탐색 시작
			int len=Q.size(); //중요 각 level의 원소 개수만큼 len 반복
			for(int i=0; i<len; i++){
				int v = Q.poll();
				//현수가 한 번은 앞으로 1, 뒤1, 앞5 움직임 가능
				for(int nv : new int[]{v+1, v-1, v+5}){
					if(nv == e) return L+1; //송아지 찾은 경우 
					if(nv > 0 && nv <= 10000 && ch[nv] == 0){
						ch[nv] = 1;
						Q.offer(nv); //자식들 넣기
					}
				}
			}
			L++;
		}
		return 0;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(5, 14));
		System.out.println(T.solution(8, 3));
	}
}
