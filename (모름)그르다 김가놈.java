import java.util.*;
class Main {
	static ArrayList<Long> arr;
	private static long binary(long n, long m){
		long answer = 0;
	
		long max = Collections.max(arr);
		long left = 1;
		long right = (long)max;

		while(left <= right){
			long sum = 0;
			long mid = (left + right) / 2; //조각 김밥의 최대 길이.
			
			for(long x : arr){
				sum += x / mid;
			}

			if(sum < m){
				right = mid - 1;
			}
			else{
				answer = mid;
				left = mid + 1;
			}
		}
		return answer;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt(); // 김밥 개수
		long k = sc.nextInt(); // 꼬다리 길이
		long m = sc.nextInt(); // 김밥조각
		arr = new ArrayList<>();

		for(int i=0; i<n; i++){
			int x = sc.nextInt(); //김밥 길이

			if(x > k*2){
				arr.add(x - 2*k);
			}
			else if(x < 2*k && x > k){
				arr.add(x - k);
			}
			
			// 김밥 길이가 k이거나 그보다 짧으면 김밥 폐기.
		}
		if(arr.size() == 0){
			System.out.println(-1);
			System.exit(0);
		}
		
		
		System.out.println(binary(n,m));
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
