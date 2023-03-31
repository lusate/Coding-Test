import java.util.*;
class Solution{
	public int solution(int[] plantTime, int[] growTime){
		int answer=0;
		int n = growTime.length;

		//growTime이 긴 것부터 내림차순으로 정렬.
		ArrayList<int[]> arr = new ArrayList<>();
		for(int i=0; i<n; i++){
			arr.add(new int[]{plantTime[i], growTime[i]});
		}


		//growTime이 긴 것부터 내림차순으로 정렬. -> 모든 꽃이 피기까지 걸리는 최단 시간.
		arr.sort((a,b) -> b[1] - a[1]);

		int st = 0;
		int ed = 0; //시작 + 끝 + 자라는 시간 -> 각각의 꽃이 피기까지 걸리는 시간.
		for(int[] x : arr){
			ed = st + x[0] + x[1];
      
      //끝까지 구한 ed보다 큰 ed가 있으면 그 ed가 실제 끝나는 시간이므로 max를 해준다.
			answer = Math.max(answer , ed);
			st += x[0];

			
		}

		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
		System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
		System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
	}
}


/* 출력
8
11
54
*/
