import java.util.*;
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			num[i] = sc.nextInt();
		}
		for(int i=1; i<=n; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(num[i] > num[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(n - dp[n]);
	}
}
