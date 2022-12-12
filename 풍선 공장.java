import java.util.*;
class Main {
	private static long binary(int n, int m, int[] arr){
		long answer = 0;
		int max = Arrays.stream(arr).max().getAsInt();

		long left = 0;
		long right = (long)max*m;
		while(left <= right){
			long mid = (left+right) / 2;
			long sum = 0;

			for(int i=0; i<n; i++){
				sum += mid / arr[i]; // sum은 mid시간 일 때 총 풍선 개수.
			}

			if(sum < m) left = mid + 1; //총 풍선 개수가 m 보다 작으면 left를 늘림.
			else{
				answer = mid; //mid시간일 때 총 풍선 개수가 m보다 같거나 크면 right 줄임.
				right = mid - 1;
			}
		}

		return answer;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		System.out.println(binary(n, m, arr));

	}
}


/* 입력
3 8
5 7 3
*/


/* 출력
14
*/
