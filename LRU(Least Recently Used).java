import java.util.*;
public class Main{
	public int[] solution(int size, int n, int[] arr){
		int[] cache = new int[size];
		for(int x : arr){
			int pos = -1; //인덱스 번호 -> cache에 존재하지 않는 인덱스 번호
			for(int i=0; i<size; i++){
				if(x == cache[i]){ //히트인 경우는 x가 cache에 존재할 때이다.
					pos = i; //존재하면 위치를 히트가 생긴 인덱스로 저장
				}
			}

			if(pos == -1){ //miss인 경우
				for(int i=size-1; i>=1; i--){
					cache[i] = cache[i-1];
				}
			}
			else{ // 히트라면
				for(int i=pos; i>=1; i--){
					cache[i] = cache[i-1];
				}
			}
			cache[0] = x;
		}
		return cache;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(); //캐시 크기
		int n = sc.nextInt(); //작업 번호 개수
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		for(int x : T.solution(s, n, arr)){
			System.out.print(x + " ");
		}
	}
}


/* 입력
5 9
1 2 3 2 6 2 3 5 7
*/

/* 출력
7 5 3 2 6

*/
