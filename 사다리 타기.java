import java.util.*;
class Main{
	private static char[] solution(int n, int[][] map){
		char[] answer = new char[n];
		for(int i=0; i<n; i++){
			//n만큼 알파벳 순으로 정렬.
			answer[i] = (char)(i+65);
		}

		for(int[] line : map){
			for(int x : line){
				char tmp = answer[x];
				answer[x] = answer[x-1];
				answer[x-1] = tmp;
			}
		}

		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}}));
		System.out.println(solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}}));
	}
}


/* 출력
[D,B,A,C,E]
[A,C,B,F,D,G,E]
*/
