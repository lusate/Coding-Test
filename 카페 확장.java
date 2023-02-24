import java.util.*;
class Solution {
    public int solution(int[] menu, int[] order, int k) {
		int answer = 0;
		int idx = 0;
		int cnt = 0;
		int[] endTime = new int[order.length];

		for(int i=0; i<order.length; i++){
			//처음 시간이 마지막 k시간보다 사람 수 감소.
			while(idx < i && endTime[idx] <= k*i){
				cnt--;
				idx++;
			}

			cnt++;
			if(i == 0){
				endTime[i] = menu[order[0]]; //처음 시간.
			}
			else{ //각 주문이 끝나는 시간을 처리.
				endTime[i] = Math.max(endTime[i-1], k*i) + menu[order[i]];
			}

			answer = Math.max(answer, cnt);
		}

        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{5, 12, 30}, new int[]{1, 2, 0, 1}, 10));
		System.out.println(T.solution(new int[]{5, 12, 30}, new int[]{2,1,0,0,0,1,0}, 10));
		System.out.println(T.solution(new int[]{5, 12, 30}, new int[]{0,0,0,0,0}, 5));
	}
}


/* 출력
3
4
1
*/
