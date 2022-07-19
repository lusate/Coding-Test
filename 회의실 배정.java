import java.util.*;
class Main{
	public int solution(int[][] times){
		int answer=0;
		Arrays.sort(times, (a,b) -> a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);
		//끝점 [1] 이 같다면 [0]을 기준으로 오름차순 같지 않으면 [1]을 기준으로 오름차순
		//a[0]-b[0] : [0]을 기준으로 오름차순
		//a[1]-b[1] : [1]을 기준으로 오름차순
		//[0] 이 시작점, [1]이 끝점

		int et=0; //et 는 새로 갱신할 끝점
		for(int[] x : times){
			if(x[0] >= et){
				answer++; //회의 수
				et = x[1];
				System.out.println("et:"+et);
			}
			//x[0]이 시작점, x[1]은 끝점

		}
		return answer;
    }//0 이면 시작점, 1이면 끝점
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{1, 4}, {2, 3}, {3, 5}, {4, 6}, {5, 7}}));
	}
}
