import java.util.*;
class Solution {
    public int[] solution(int[] arrival, int[] state) {
		Queue<Integer> enterQ = new LinkedList<>();
		Queue<Integer> exitQ = new LinkedList<>();

		int n = arrival.length;
		int[] answer = new int[n];
		
		int prev = 0; //나가지도 들어오지도 않으면 prev를 -1
		
		for(int t=0, i=0, cnt=0; ; t++){ //t는 시간
			if(enterQ.isEmpty() && exitQ.isEmpty()){
				if(t < arrival[i]){
					t = arrival[i]; //비어있으면 초를 바꿈.
					prev = -1; //들락 날락 안 함 -> 아무일도 안 일어남.
				}
			}

			while(i < n && t >= arrival[i]){ //i가 번호
				if(state[i] == 0) enterQ.offer(i);
				else exitQ.offer(i);
				i++;
			}
			
			if(prev == -1){
				if(!exitQ.isEmpty()){
					answer[exitQ.poll()] = t;
					prev = 1;
					//1초 전에 현관문을 사용한 적이 없으면 나가는 사원이 먼저 현관문을 이용
				}

				else if(!enterQ.isEmpty()){ //들어오면 0처리
					answer[enterQ.poll()] = t;
					prev = 0;
				}
			}

			else if(prev == 0){
				if(!enterQ.isEmpty()){ //들어오는 사람 먼저
					answer[enterQ.poll()] = t;
					prev = 0;
				}
				else if(!exitQ.isEmpty()){ //누군가 한 쪽에는 있으므로 굳이 else if 할 필요는 없음.
					answer[exitQ.poll()] = t;
					prev = 1;
				}
			}
			else if(prev == 1){
				if(!exitQ.isEmpty()){
					answer[exitQ.poll()] = t;
					prev = 1;
				}
				else if(!enterQ.isEmpty()){ //누군가 한 쪽에는 있으므로 굳이 else if 할 필요는 없음.
					answer[enterQ.poll()] = t;
					prev = 0;
				}
			}

			cnt++;
			if(cnt == n) break;
		}
		
		return answer;
    }


	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 7}, new int[]{1, 0, 0, 1, 0, 1, 1})));
		// System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
		// System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
		
	}
}

/* 출력
[0, 2, 3, 1, 4, 5, 7]
[3, 6, 4, 7, 5, 8]
[2, 3, 4, 5, 6, 8, 11, 9, 10, 12]
*/
