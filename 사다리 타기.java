import java.util.*;
public class Main {
	private static char[] solution(int n, int[][] map) {
		char[] answer = new char[n];
		char tmp;
		int s;

		for(int i=0; i<n; i++){
			answer[i] = (char) (i + 65);
		}


		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[i].length; j++){
				s = map[i][j] - 1;

				tmp = answer[s];
				answer[s] = answer[s+1];
				answer[s+1] = tmp;
			}
		}


		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}}));
		System.out.println(solution(7, new int[][]{{1, 3, 5}, {1 , 3, 6}, {2, 4}}));
		
	}
}

/* 출력
[D,B,A,C,E]
[A,C,B,F,D,G,E]
*/
