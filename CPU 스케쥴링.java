import java.util.*;
class Solution{
	public int[] solution(int[][] tasks) {
		
		int n = tasks.length;
		ArrayList<Integer> res = new ArrayList<>();
		LinkedList<int[]> programs = new LinkedList<>();

		for(int i=0; i<n; i++){
			programs.add(new int[]{i, tasks[i][0], tasks[i][1]}); //i는 작업 번호, 시작 시간, 실행 시간
		}
		programs.sort((a,b) -> a[1] - b[1]);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
		
		int cur=0;
		while(!programs.isEmpty() || !pq.isEmpty()){
			if(pq.isEmpty()){
				cur = Math.max(cur, programs.peek()[1]);
			}

			while(!programs.isEmpty() && programs.peek()[1] <= cur){
				int[] tmp = programs.pollFirst();
				pq.add(new int[]{tmp[0], tmp[2]}); // (작업 번호, 실행 시간)
			}

			int[] e = pq.poll(); // (작업 번호, 실행 시간)
			cur += e[1]; //e[0]이 실행 시간, e[1]이 작업 번호

			res.add(e[0]);
		}
		
		int[] answer = new int[n];
		for(int i=0; i<n; i++) answer[i] = res.get(i);
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[][]{
			{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));

		System.out.println(Arrays.toString(T.solution(new int[][]{
			{2, 3}, {1, 2}, {4, 2}, {3, 1}})));

		System.out.println(Arrays.toString(T.solution(new int[][]{
			{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
	}
}



/* 출력
[1, 3, 0, 2, 4]
[1, 3, 2, 0]
[5, 4, 2, 0, 1, 3]
*/
