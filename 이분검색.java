import java.util.*;

class Main{
	public int solution(int n, int m, int[] arr) {
		int answer=0;
		Arrays.sort(arr);
		
		int left = 0;
		int right = n-1;
		//12가 left, 99가 right 해서 mid = (left + right) / 2
		while(left<=right) {
			int mid = (left+right) / 2;
			if(arr[mid] == m) {
				answer = mid+1;
				break;
			}
			if(arr[mid] > m) {
				//m보다 큰 구간은 없앰.
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(n, m, arr));
	}
}


/* 입력
8 32
23 87 65 12 57 32 99 81
*/

/* 출력
3
*/
