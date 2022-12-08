import java.util.*;
class Main {
	private static int binary(int n, int m, int[] arr){
		int answer = 0;
		int left = Arrays.stream(arr).min().getAsInt();
		int right = Arrays.stream(arr).max().getAsInt();

		while(left <= right){
			int sum = 0;
			int mid = (left + right) / 2; //조각 김밥의 최대 길이.
			if(mid <= 0){
				System.out.println("끝");
				System.exit(0);
			}
			for(int i=0; i<n; i++){
				sum += arr[i] / mid;
			}

			if(sum < m){
				right = mid - 1;
			}
			else{
				left = mid + 1;
				answer = mid;
			}
		}
		return answer;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 김밥 개수
		int k = sc.nextInt(); // 꼬다리 길이
		int m = sc.nextInt(); // 김밥조각
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt(); //김밥 길이

			if(arr[i] >= k*2){
				arr[i] = arr[i] - 2*k;
			}
			else if(arr[i] < 2*k && arr[i] > k){
				arr[i] = arr[i] - k;
			}

			else if(arr[i] <= k){
				arr[i] = 0;
			}
		}
		
		
		System.out.println(binary(n,m,arr));
	}
}


/* 입력
3 6 4
20
10
3


3 8 1
16
7
8
*/


/* 출력
2

-1
*/
