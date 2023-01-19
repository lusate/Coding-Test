import java.util.*;
class Solution{
	public int getTime(String s){
		int H = Integer.parseInt(s.split(":")[0]);
		int M = Integer.parseInt(s.split(":")[1]);

		return H*60+M;
	}
	public int solution(int[] laser, String[] enter) {
		int answer = 0;
		int n = enter.length;
		int[][] list = new int[n][2];

		for(int i=0; i<n; i++){
			int a = getTime(enter[i].split(" ")[0]);
			int b = Integer.parseInt(enter[i].split(" ")[1]);
			list[i][0] = a;
			list[i][1] = b;
		}

		Queue<Integer> Q = new LinkedList<>();
		Q.offer(list[0][1]);
		int finish = list[0][0];
		int pos = 1;
		for(int t = finish; t<=1200; t++){
			if(pos < n && t == list[pos][0]){ //여기서 finish가 653이 됐다고 해서 t가 653으로 갱신되는 것이 아니다.
				if(Q.isEmpty() && finish < list[pos][0]) finish = list[pos][0];
				Q.offer(list[pos][1]);
				pos++;
			}
			
			if(t == finish && !Q.isEmpty()){
				int idx = Q.poll();
				finish = finish + laser[idx];
			}

			answer = Math.max(answer, Q.size());
		}



		
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{30, 20, 25, 15}, 
		new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0",
		"15:25 0"}));

		// System.out.println(T.solution(new int[]{30, 20, 25, 15}, 
		// new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3",
		// "11:10 2"}));
	}
}


/* 출력
4
3
*/
