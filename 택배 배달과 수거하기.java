import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
		int d = 0; //배달 택배 수
		int p = 0; //수거 택배 수

		for(int i=n-1; i>=0; i--){
			//제일 멀리 있는 배달 혹은 수거가 남아있다면 무조건 그 거리를 다시 방문해야 하므로 deliveries 배열과
			//pickups 배열을 동시에 확인한다.
			if(deliveries[i] != 0 || pickups[i] != 0){
				int cnt = 0; //해당 장소를 방문한 횟수.

				while(d < deliveries[i] || p < pickups[i]){
					d += cap;
					p += cap;
					cnt++;
				}

				d -= deliveries[i];
				p -= pickups[i];
				answer += (i+1) * 2 * cnt;
			}			
		}
        
        
        
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
		System.out.println(T.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
	}
}

/* 출력
16
30
*/
