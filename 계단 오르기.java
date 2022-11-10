import java.util.*;
class Solution{
	static int[] dp;
	public int solution(int n) {
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		return dp[n];
	}
	public static void main(String[] args) {
		Solution T = new Solution();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		dp = new int[n+1];
		System.out.println(T.solution(n));
	}
}
