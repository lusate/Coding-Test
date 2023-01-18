import java.util.*;
class Solution{
	public int[] solution(int[][] tasks) {
		
		int n = tasks.length;
		ArrayList<Integer> res = new ArrayList<>();
		LinkedList<int[]> programs = new LinkedList<>();

		for(int i=0; i<n; i++){
			programs.add(new int[]{tasks[i][0], tasks[i][1], i}); //i는 작업 번호
		}
		programs.sort((a,b) -> a[0] - b[0]);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		
		int cur=0;
		while(!programs.isEmpty() || !pq.isEmpty()){
			if(pq.isEmpty()){
				cur = Math.max(cur, programs.peek()[0]);
			}

			while(!programs.isEmpty() && programs.peek()[0] <= cur){
				int[] tmp = programs.pollFirst();
				pq.add(new int[]{tmp[1], tmp[2]});
			}

			int[] e = pq.poll();
			cur += e[0]; //e[0]이 실행 시간, e[1]이 작업 번호

			res.add(e[1]);
		}
		
		int[] answer = new int[n];
		for(int i=0; i<n; i++) answer[i] = res.get(i);
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[][]{
			{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));

		// System.out.println(Arrays.toString(T.solution(new int[][]{
		// 	{2, 3}, {1, 2}, {4, 2}, {3, 1}})));

		// System.out.println(Arrays.toString(T.solution(new int[][]{
		// 	{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
	}
}



/* 출력
[1, 3, 0, 2, 4]
[1, 3, 2, 0]
[5, 4, 2, 0, 1, 3]
*/
