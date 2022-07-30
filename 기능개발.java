import java.util.*;
class Main {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> Q = new LinkedList<>();
		ArrayList<Integer> tmp = new ArrayList<>();

		for(int i=0; i<progresses.length; i++){
			Q.offer((100 - progresses[i]) / speeds[i] + 
			((100 - progresses[i]) % speeds[i] == 0 ? 0 : 1));
		}

		int cnt = 1;
		int now = Q.poll();
		while(!Q.isEmpty()){
			int next = Q.poll();
			if(now >= next){
				cnt++;
			}
			else{
				tmp.add(cnt);
				now = next;
				cnt = 1;
			}
		}
		tmp.add(cnt);

		//ArryList를 배열로 변환
		int[] answer = new int[tmp.size()];
		for(int i=0; i<answer.length; i++){
			answer[i] = tmp.get(i);
		}
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		int[] pro = new int[]{93, 30, 55};
		int[] spd = new int[]{1, 30, 5};
		for(int x : T.solution(pro, spd)){
			System.out.print(x + " ");
		}
	}
}
