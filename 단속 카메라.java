import java.util.*;
public class Main {
	public int solution(int[][] routes) {
		int answer = 1;
		Arrays.sort(routes, (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);

		int et = routes[0][1];
		for(int i=1; i<routes.length; i++){
			if(routes[i][0] > et){
				answer++;
				et = routes[i][1];
			}
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[][] routes = new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
		System.out.println(T.solution(routes));
	}
}
