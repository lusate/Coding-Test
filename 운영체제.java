import java.util.*;
class Solution {
    public long[] solution(int[][] program) {
		int n = program.length;
		long[] answer = new long[11];

		//점수가 낮은 것이 우선 순위
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		LinkedList<int[]> list = new LinkedList<>();

		for(int i=0; i<n; i++){
			list.add(new int[]{program[i][0], program[i][1], program[i][2]});
		}
		list.sort((a,b) -> a[1] - b[1]);

		int curT = 0;
		while(!list.isEmpty() || !pq.isEmpty()){
			//시작한 프로그램이 없을 경우 프로그램 시작 시간으로 교체.
			if(pq.isEmpty()) Math.max(curT, list.peek()[1]);

			while(!list.isEmpty() && list.peek()[1] <= curT){
				int[] x = list.pollFirst();
                pq.offer(new int[]{x[0], x[1], x[2]});				
			}


			int[] e = pq.poll(); //실행
			//점수에 따른 대기시간 합
            answer[e[0]] += (curT - e[1]);
            curT += e[2];
		}
        

		answer[0] = curT;
        return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[][]{{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}})));
	}
}


/* 출력
[20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0]
[19, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0]
*/
