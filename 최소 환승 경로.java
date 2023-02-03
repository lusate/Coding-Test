import java.util.*;
class Solution {
    public int solution(int[][] routes, int s, int e) {
		int answer = 0;
		HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

		for(int i=0; i<routes.length; i++){  //열 길이
			for(int x : routes[i]){
				graph.putIfAbsent(x, new HashSet<Integer>());
				graph.get(x).add(i);
			}
		}
		System.out.println(graph);

		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		int[] visit = new int[routes.length];
		int L = 0;
		while(!q.isEmpty()){
			int len = q.size();
			for(int i=0; i<len; i++){
				int tmp = q.poll(); //정지한 역번호
				for(int line : graph.get(tmp)){ //호선 번호
					if(visit[line] == 1) continue;
					
					for(int stop : routes[line]){
						if(stop == e) return L;
						q.offer(stop);
					}
				}
			}
			L++;
		}


		return answer;
	}
    

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{
			{1, 3, 5, 7, 9, 11},
			{10, 3, 14},
			{8, 5, 6},
			{2, 7, 13},
			{10, 8, 2, 17},
			{14, 5, 2, 12}}, 1, 12));

		System.out.println(T.solution(new int[][]{
			{1, 2, 3, 4, 5},
			{9, 7, 10},
			{7, 6, 3, 8},
			{5, 11, 8, 12}}, 1, 10));

	}
}


/* 출력
1
2
*/
