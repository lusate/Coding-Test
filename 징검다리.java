import java.util.*;
class Solution {
	//징검다리 제거 개수
	public int count(int[] rocks, int mid, int distance){
		int st = 0; //시작점.
		int ep = distance;

		int cnt = 0;
		for(int i=0; i<rocks.length; i++){
			if(rocks[i] - st < mid){ // 지정한 최고 거리보다 바위 사이 거리가 작으면
				cnt++; // 제거한 바위 카운트
				continue; // 제거 했으므로 st를 갱신하지 않기 위해서 continue
			}
			st = rocks[i]; // mid보다 크므로 st 갱신.
		}
		if(ep - st < mid) cnt++; // 마지막에 있는 바위 distance에 있는 것도 카운트

		return cnt;
	}
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		Arrays.sort(rocks);
		
		int lt = 1; // 최소 거리
		int rt = distance; // 최대 거리
		while(lt <= rt){
			int mid = (lt + rt) / 2;

			//mid 대로 count()에서 제거한 바위 개수가 n보다 작으면 크기 늘려서 다시.
			if(count(rocks, mid, distance) <= n){
				//카운트 할 때 큰 값 ->은작은 값 이므로 <= 로 해준다.
				answer = mid;
				lt = mid + 1;
			}
			else rt = mid - 1; //아니면 크기 줄임.
		}

		return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(25, new int[]{2, 14, 11, 21, 17}, 2));
	}
}


/* 출력
4
*/
