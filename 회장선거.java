import java.util.*;
class Main{
	//n은 반 학생수, k는 추천 횟수
	public ArrayList<Integer> solution(int n, int[][] votes, int k){
		ArrayList<Integer> answer = new ArrayList<>();
		int[][] result = new int[n][n];
		int[] candidate = new int[n];

		for(int[] x : votes){
			result[x[0]][x[1]] = 1;
		}
		//i행 -> 추천을 한 학생
		//j열 -> 추천을 받은 학생

		for(int i=0; i<n; i++){
			int cnt=0;
			for(int j=0; j<n; j++){
				//추천을 받은 수를 카운트 해야 하므로 [j][i]로 한다.
				if(result[j][i] == 1){
					cnt++;
				}//result 뽑힌 결과
				//System.out.print(result[j][i]);
			}
			if(cnt >= k){
				candidate[i] = 1;
			}
			//System.out.print(candidate[i]);
			//1,0,0,1
		}
		
		//후보인 학생들이 추천해준 학생들에게 이메일을 보냄
		for(int i=0; i<n; i++){
			int cnt=0;
			for(int j=0; j<n; j++){
				if(candidate[j] == 1 && result[i][j] == 1){
					cnt++;
				}
			}
			//이메일을 받는 횟수
			answer.add(cnt);
		}
		
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[][] arr={{0, 1}, {0, 3}, {1, 2}, {2, 0}, {2, 3}, {3, 0}};

		System.out.println(T.solution(4, arr, 2));
	}
}


//답
//[1, 0, 2, 1]
