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
				//1번과 2번을 바꿀려면 인덱스 상으로 0과 1의 위치를 바꿔야 하므로
				//처음 x=1 이기 때문에 [x-1]을 해서 0과 바꾼다.
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
