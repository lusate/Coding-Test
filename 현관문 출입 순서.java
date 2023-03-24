import java.util.*;
class Solution {
    public int[] solution(int[] arrival, int[] state) {
		Queue<Integer> enterQ = new LinkedList<>();
		Queue<Integer> exitQ = new LinkedList<>();

		int n = arrival.length;
		int[] answer = new int[n];
		
	    	//나가기 위해 현관문 사용하면 1, 들어오기 위해 사용하면 0
		int prev = 1; //나가지도 들어오지도 않으면 prev를 -1
		
		for(int t=0, i=0, cnt=0; ; t++){ //t는 시간, i는 사원 번호, cnt는 현관문 사용한 사람 수
			//현관문 사용하기 위해 대기하고 있는 사람이 없다는 뜻
			if(enterQ.isEmpty() && exitQ.isEmpty() && i<n){
				if(t < arrival[i]){ //현재 시간이 작으면 건너띈다.
					t = arrival[i]; //비어있으면 초를 바꿈.
					prev = 1; 
				}
			}

			while(i < n && t >= arrival[i]){ //i가 번호
				if(state[i] == 0) enterQ.offer(i); //들어오면 enterQ에 삽입
				else exitQ.offer(i);
				i++;
			}
			
			if(prev == 1){ //1초 전에 현관문을 사용하지 않았거나 나가는 사원의 경우
				if(!exit.isEmpty()){
					answer[exit.poll()] = t;  // exit.poll()는 사원 번호
					prev = 1;
				}
				else{ // 나가는 사원이 없음 들어오는 사람이 사용
					answer[enter.poll()] = t;
					prev = 0;
				}
			}

			else if(prev == 0){
				if(!enter.isEmpty()){
					answer[enter.poll()] = t;
					prev = 0;
				}
				else{
					answer[exit.poll()] = t;
					prev = 1;
				}
			}

			cnt++;
			if(cnt == n) break; //현관문 사용한 사람 수가 n과 같아지면 break
		}
		
		return answer;
    }


	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 7}, new int[]{1, 0, 0, 1, 0, 1, 1})));
		System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
		System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
		
	}
}

/* 출력
[0, 2, 3, 1, 4, 5, 7]
[3, 6, 4, 7, 5, 8]
[2, 3, 4, 5, 6, 8, 11, 9, 10, 12]
*/
