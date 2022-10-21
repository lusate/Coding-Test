import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		

		for(int test_case = 1; test_case <= T; test_case++){
			
			int n = sc.nextInt(); //일
			long answer = 0; //이익
			int max_value = 0;
			int[] arr = new int[n];
			for(int i=0; i<n; i++){
				arr[i] = sc.nextInt();
			}
			for(int i=n-1; i>=0; i--){
				if(arr[i] > max_value) max_value = arr[i];
				answer += max_value - arr[i];
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}

// 1 1 3 1 2  일 경우 
// 최대값을 2로 시작해서 2-2 = 0
// 2 - 1 = 1
// 3이므로 최대값을 3으로 설정.
// 3 - 3 = 0
// 3 - 1 = 2
// 3 - 1 = 2
// 그래서 0 + 1 + 0 + 2 + 2 = 5가 최대 수익이 된다.
