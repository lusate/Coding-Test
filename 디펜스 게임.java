import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
		int answer = 0;
		if(k == enemy.length){
			return enemy.length;
		}

		int cnt=0;
		int remain=n;
		int i=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(i=0; i<enemy.length; i++){
			int cur = enemy[i];
			pq.add(cur);
			remain -= cur;

			if(remain < 0){
				if(cnt < k){
					remain += pq.poll();
					cnt++;
				}
				else break;
			}

			// if(remain < 0){
			// 	// cnt를 k로 설정.
			// 	if(cnt > 0 && !pq.isEmpty()){
			// 		remain += pq.poll();
			// 		cnt--;
			// 	}
			// 	else {
			// 		answer = i;
			// 		break;
			// 	}
			// }
		}

		answer = i;
		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
		System.out.println(T.solution(2, 4, new int[]{3, 3, 3, 3}));
	}
}


/* 출력
5
4
*/
