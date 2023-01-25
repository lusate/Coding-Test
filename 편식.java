import java.util.*;
class Solution {
	int answer;
	int[] pow, student;
	int N;
	public void dfs(int s, int sum, int T){ //sum은 양념 번호, T는 양념 재료 개수
		//조합
		boolean flag = true;
		for(int i=0; i<N; i++){
			if((sum & student[i]) == student[i]){ //student[i]은 학생들이 먹지 못하는 양념
				flag = false;
				break;
			}
		}

		if(flag) answer++;

		for(int i=s; i<=T; i++){
			dfs(i+1, sum+pow[i], T);
		}
		

	}
    public int solution(int T, int[][] hate) {
		answer = 0;
		pow = new int[T+1]; //양념 20개까지
		student = new int[100];
		N = hate.length;

		for(int i=1; i<=T; i++){
			pow[i] = (int) Math.pow(2, i-1);
		}


		for(int i=0; i<N; i++){
			for(int x : hate[i]){
				student[i] += pow[x]; //학생들 싫어하는 양념 십진수
			}
			// System.out.print(student[i] + " ");
			// 1 10 38 16 44 10
		}

		

		dfs(1, 0, T);

		return answer;
    }

	public static void main(String args[]){
		Solution T = new Solution();
		System.out.println(T.solution(6, new int[][]{{1}, {4,2}, {3,2,6}, {5}, {3,4,6}}));

		// System.out.println(T.solution(6, new int[][]{{3, 1, 4}, {6, 1, 4}, {1}, {4,1,5,6,3}, {4, 2, 3}, 
		// {2,4,6}, {1,6}, {2}, {4,5,1}}));

		// System.out.println(T.solution(7, new int[][]{{3, 1, 6}, {5}, {4,1,7}, {1,7,4,5,2,3,6}, {7,2,4,3,1,5}, 
		// {5,4,2}, {7,2}, {3,2,5}, {1,3}, {1}, {2}, {2,5,1,7,3}}));
	}
}


/* 출력
10
16
16
*/
