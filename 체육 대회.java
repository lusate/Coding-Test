import java.util.*;
class Solution{
	int answer;
    boolean[] visit;

	public void dfs(int L, int sum, int[][] arr){
		if(L == arr.length) {
            answer = Math.max(answer, sum);
            return;
        }
        
		for(int j=0; j<arr[0].length; j++){
			if(!visit[j]){
				visit[j] = true;
				sum+=arr[L][j];
				dfs(L+1,sum,arr);
				visit[j] = false;
				sum-=arr[L][j];
			}
		}
    }
	

	public int solution(int[][] ability) {
		answer = Integer.MIN_VALUE;
		int n = ability.length;
		int m = ability[0].length;

        visit = new boolean[n];
        int[][] arr = new int[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = ability[j][i];
            }
        }
        dfs(0,0,arr);
        
        return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}}));
		System.out.println(T.solution(new int[][]{{20, 30}, {30, 20}, {20, 30}}));
	}
}

/* 출력
210
60
*/
