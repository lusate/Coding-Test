import java.io.*;
import java.util.*;
public class Main {
	public long solution(int n, long[] dist, long[] cost) {
		long answer=0;
		long minCost = cost[0];

		for(int i=0; i<n-1; i++){
			if(minCost > cost[i]){
				minCost = cost[i];
			}
			answer += minCost * dist[i];
		}
		

    	return answer;
    }
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] dist = new long[n-1];
		long[] cost = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++){ //거리
			dist[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){ //1리터 당 비용.
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		System.out.println(T.solution(n, dist, cost));
	}
}
