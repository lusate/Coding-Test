import java.util.*;
class Main{
	public int[] solution(int n, int[] arr){
		for(int i=0; i<n-1; i++){
			int idx = i;
			for(int j=i+1; j<n; j++){
				if(arr[idx] > arr[j]) idx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		for(int x : arr){
			System.out.print(x + " ");
		}
		return arr;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		T.solution(n, arr);
	}
}


/* 입력
6
13 5 11 7 23 15
*/

/* 출력
5 7 11 13 15 23
*/
