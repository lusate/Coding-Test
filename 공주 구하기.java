import java.util.*;
class Main {
	// 왕자 N명, 공주 구하러 가는데서 제외되는 번호 K번
	public int solution(int n, int k){
		int answer=0;
		Queue<Integer> Q = new LinkedList<>();

		//n명의 왕자를 모두 큐에 삽입, n(왕자 수) = 8
		for(int i=1; i<=n; i++){
			Q.offer(i);
		}

		//큐가 비워질 때까지 반복
		while(!Q.isEmpty()){
			//k 외치면 그 왕자는 공주를 구하러 가는데서 제외

			//k번이 아닌 왕자는 poll 했다가 다시 offer
			for(int i=1; i<k; i++){
				Q.offer(Q.poll()); //뺀 숫자를 다시 집어넣음
			}
			
			Q.poll(); //k번은 poll

			if(Q.size()==1){ //마지막 원소 하나가 남은 경우
				//마지막 하나를 poll 해서 비워버리고 while 반복문 끝남
				//마지막 남은 하나가 답
				answer = Q.poll();
			}
		}
		
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(8, 3));
	} 
}
