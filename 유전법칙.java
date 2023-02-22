//재귀로 푸는 방법
import java.util.*;
class Solution {
	public String dfs(int cnt, int idx){
		if(cnt == 1) return "Rr";

		String parent = dfs(cnt-1, (idx-1) / 4 + 1);
		//찾으려고 하는 것의 부모가 RR or rr이면 찾을 필요 없이 그냥 RR or rr임.
		if(parent.equals("RR") || parent.equals("rr")) return parent;

		//4개씩 자식이 생기므로 % 4
		int group = (idx-1) % 4;
		if(group == 0) return "RR"; //자식 부분의 인덱스에 따라 반환.
		if(group == 1 || group == 2) return "Rr";
		if(group == 3) return "rr";

		return "";
	}

    public String[] solution(int[][] queries) {
		int n = queries.length;
		String[] answer = new String[n];

		for(int i=0; i<n; i++){
			answer[i] = dfs(queries[i][0], queries[i][1]);
		}
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[][]{{3, 5}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{3, 8}, {2, 2}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{3, 1}, {2, 3}, {3, 9}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{4, 26}})));
	}
}


/* 출력
["RR"]
["rr", "Rr"]
["RR", "Rr", "RR"]
["Rr"]
*/

//------------------------------------------------------------------------------------------------------------------------------------------------------

//스택으로 푸는 방법
import java.util.*;
class Solution {
	String[] str = {"RR", "Rr", "Rr", "rr"};
    public String[] solution(int[][] queries) {
		int n = queries.length;
        String[] answer = new String[n];
		
		for(int i=0; i<n; i++){
			int cnt = queries[i][0];
			int idx = queries[i][1] - 1;

			Stack<Integer> stack = new Stack<>();
			if(cnt == 1) answer[i] = "Rr";
			else{
				while(cnt --> 1){
					stack.push(idx % 4);
					idx /= 4;
				}

				boolean flag = false;
				while(!stack.empty()){
					int tmp = stack.pop();
					if(tmp == 0 || tmp == 3){
						answer[i] = str[tmp];
						flag = true;
						break;
					}
				}

				if(!flag) answer[i] = "Rr";
			}
		}
        return answer;
    }
}
