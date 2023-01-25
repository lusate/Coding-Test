import java.util.*;
class Solution {
    public int solution(int[][] apples, int s, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int[] apple : apples){
			map.put(apple[0], apple[1]);
		}
		System.out.println(map);

		int[] maxL = new int[k+1];
		int[] maxR = new int[k+1];
		maxL[0] = map.getOrDefault(s, 0);
		maxR[0] = map.getOrDefault(s, 0);

		int answer = maxL[0];
		for(int i=1; i<=k; i++){
			if(s - i >= 0){ //왼쪽으로만 이동
				maxL[i] = maxL[i-1] + map.getOrDefault(s-i, 0); //다음 위치에 사과가 없을 수도 있음.
			}

			else{ //왼쪽으로 이동하는데 이동 k번을 넘어버리면 이전 값으로 설정
				maxL[i] = maxL[i-1];
			}
			answer = Math.max(answer, maxL[i]);

			//오른쪽으로만 이동
			maxR[i] = maxR[i-1] + map.getOrDefault(s+i, 0); 
			answer = Math.max(answer, maxR[i]);
		}

		//왼, 오 둘다 일 때
		for(int j=1; j<(k+1) / 2; j++){
			answer = Math.max(answer, maxL[j] + maxR[k-2*j] - maxR[0]);
			answer = Math.max(answer, maxR[j] + maxL[k-2*j] - maxL[0]);
		}

		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0, 10},{2,3},{5,8},{6,5},{8,6},{9,5},{10,2},{12,3}}, 7, 5));
		// System.out.println(T.solution(new int[][]{{0, 9},{4,5},{5,7},{6,2},{7,4},{9,3},{10,9}}, 5, 4));
		// System.out.println(T.solution(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}}, 5, 4));
		// System.out.println(T.solution(new int[][]{{0,12},{2,10},{12,5}}, 8, 3));
	}
}


/* 출력
19
18
14
0
*/
