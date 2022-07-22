import java.util.*;
class Main{
	public int solution(int[][] body){
		int answer = 0;
		Arrays.sort(body, (a,b) -> b[0]-a[0]);
		//키 [0] 를 기준으로 내림차순

		int max = 0;
		for(int[] x : body){
			if(x[1] > max){ //여기 암기
				answer++; // 씨름 선수 카운트
				max = x[1]; // 처음 0보다 큰 65로 갱신 다음은 70으로 갱신, 72로 갱신
			}
		}

		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{172, 67}, {183, 65}, {180, 70}, {170, 72}, {181, 60}}));
	}
}
