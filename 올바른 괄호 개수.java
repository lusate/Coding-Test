import java.util.*;
public class Main {
	public int solution(int n) {
		int dp[] = new int[n+1];

		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++){
			for(int j=1; j<=i; j++){
				dp[i] += dp[i-j] * dp[j-1];
			}
		}
		
		return dp[n];
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(2));
		System.out.println(T.solution(3));
	}
}


/*
i=2 일 때 j=1
dp[2] = dp[2] + dp[1] * dp[0]
dp[2] = dp[2] + 1
dp[2] = 1

i=2일 때 j=2
dp[2] = 1 + dp[0] * dp[1]
dp[2] = 2

i=3, j=1
dp[3] = dp[3] + dp[2] * dp[0]
0 + 2 = 2

i=3, j=2
dp[3] = dp[3] + dp[1] * dp[1]
2 + 1 = 3

i=3, j=3
dp[3] = dp[3] + dp[0] * dp[2]
3 + 2= 5 */
