import java.util.*;
class Solution{
	private static int solution(int[][] meetings){
		int answer = 0;
		ArrayList<int[]> arr = new ArrayList<>();

		for(int[] x : meetings){
			arr.add(new int[]{x[0], 1}); //시간
			arr.add(new int[]{x[1], 2}); //상태 1이면 시작 2면 끝
		}

		arr.sort((a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);

		int cnt = 0;
		for(int[] x : arr){
			if(x[1] == 1){
				cnt++;
			}
			else cnt--;
			answer = Math.max(answer, cnt);

		}

		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0, 10}, {12, 25}, {5, 15}}));
		System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
		System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
	}
}

/* 출력
2
5
3
*/
