import java.util.*;
class Solution {
    public int[] solution(int[] enter, int[] exit) {
		int n = enter.length;

		for(int i=0; i<n; i++){
			enter[i]--;
			exit[i]--;
		}

		int[] enterIdx = new int[n];

		for(int i=0; i<n; i++){ // enter의 인덱스 순서
			enterIdx[enter[i]] = i;
		}
		
		int[] enterT = new int[n]; // 들어왔을 때 시간
		int[] exitT = new int[n]; // 나갈 때 시간

		int cnt = 0;
		int j = 0;
		for(int i=0; i<n; i++){ //i는 나가는 사람 번호, j는 들어오는 사람 번호
			while(j < n && j <= enterIdx[exit[i]]){ // 0번이 나갈려면 1번과 2번이 나가야 함. 그 시간을 구해줌.
				enterT[enter[j]] = cnt++; // 1번이 나가는 것은 0번 들어오고 1번 들어오고 1번이 나가면 됨.
				j++;
			}

			exitT[exit[i]] = cnt++; // 나갈 때의 시간을 구해줌.
		}
		// enterT[] -> [0, 1, 4, 7, 3]
		// exitT[] -> [6, 2, 5, 8, 9]

		int[] answer = new int[n];
		for(int i=0; i<n; i++){
			for(int k = i+1; k<n; k++){
				// 두 사람이 만나지 않을려면 i의 나가는 시간이 k의 들어오는 시간보다 빨라야 함.
				// 반대로 k의 나가는 시간이 i의 들어오는 시간보다 빠르면 만나지 않음.
				// 그걸 반대로 하면 무조건 만남.
				if(!(exitT[i] < enterT[k] || exitT[k] < enterT[i])){
					answer[i]++;
					answer[k]++;
				}
			}
		}

		return answer;
    }


	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
	}
}


/* 출력
[3, 1, 2, 2]
[3, 1, 2, 1, 3]
[6, 2, 2, 4, 2, 3, 4, 1]
*/
