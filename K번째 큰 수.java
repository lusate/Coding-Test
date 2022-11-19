import java.util.*;
class Main{
	public int solution(int[] arr, int n, int k){
		int answer=0;
		//TreeSet 은 중복 데이터를 저장하지 않고 저장 순서를 유지하지 않음.
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				for(int l=j+1; l<n; l++){
					Tset.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		int cnt = 0;
		//Tset.remove() 해서 삭제 가능
		for(int x : Tset){
			cnt++;
			if(cnt == k) System.out.print(x);
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		T.solution(arr, n, k);
	}
}

/* 입력
10 3
13 15 34 23 45 65 33 11 26 42
*/

/* 출력
143
*/
