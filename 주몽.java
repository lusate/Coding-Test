import java.util.*;
class Main {
	private static int solution(int n, int m, int[] arr) {
		int answer = 0;
		int left = 0;
		int right = arr.length - 1;

		Arrays.sort(arr);
		while(left < right){
			if(arr[left] + arr[right] == m){
				answer++;
				left++;
				right--;
			}
			else if(arr[left] + arr[right] < m){
				left++;
			}
			else right--;
		}
		return answer;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //재료 개수
		int m = sc.nextInt(); //갑옷을 만드는데 필요한 수
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		System.out.println(solution(n, m, arr));
	}
}


/* 입력
6
9
2 7 4 1 5 3
*/


/* 출력
2
*/
