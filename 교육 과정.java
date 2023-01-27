import java.util.*;
class Solution {
    public String[] solution(String[] subjects, String[] course) {
		HashMap<String, Integer> map = new HashMap<>();
		int n = subjects.length;
		
		for(int i=0; i<n; i++){
			map.put(subjects[i], i);
		}
		System.out.println(map);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for(int i=0; i<n; i++){
			graph.add(new ArrayList<>());
		}

		int[] indegree = new int[n];
		for(String x : course){
			int a = map.get(x.split(" ")[0]);
			int b = map.get(x.split(" ")[1]);

			graph.get(b).add(a);
			indegree[a]++;
		}


		ArrayList<Integer> order = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<n; i++){
			if(indegree[i] == 0) q.offer(i);
		}

		while(!q.isEmpty()){
			int pre = q.poll();
			order.add(pre);

			for(int x : graph.get(pre)){
				indegree[x]--;
				if(indegree[x] == 0){
					q.offer(x);
				}
			}
		}

		String[] answer = new String[n];
		for(int i=0; i<n; i++){
			answer[i] = subjects[order.get(i)];
		}

		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"english" , "math", "physics", "art", "music"}, 
		new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
	}
}
