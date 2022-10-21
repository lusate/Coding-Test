import java.util.*;
import java.io.*;

class Solution{
	static int[] arr; //점수판
	static int max = 0;
	public static void dfs(int k, int cnt, int chance){ //k는 시작 인덱스
		if(chance == cnt){
			//기회 모두 씀
			StringBuilder sb = new StringBuilder(); //문자열을 변형 시키기 위함.
			for(int i : arr){
				sb.append(i); //arr 배열에 있는 문자열을 sb에 넣음.
			}

			//sb에 있는 문자열을 숫자로 변환해서 max 비교하면서 초기화해줌.
			max = Math.max(max, Integer.parseInt(sb.toString()));
			return;
		}

		for(int i=k; i<arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i] <= arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

					dfs(i, cnt+1, chance);
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			//최댓값 초기화
			max = 0;

			//번호 입력
			int num = sc.nextInt();

			//바꿀 기회 입력
			int chance = sc.nextInt();
			
			//int -> int[] 바꾸는 방법
			arr = Integer.toString(num).chars().map(c -> c - '0').toArray();
			//num을 String 바꾸고 다시 chars 로 변환
			//그 다음 문자 - '0' => 즉 (문자 - 48) 하고 toArray()로 배열로 만들어줌.

			dfs(0, 0, chance);
			System.out.println("#" + test_case + " " + max);
		}
		return;
	}
}


/* 입력
10
123 1
2737 1
757148 1
78466 2
32888 2
777770 5
436659 2
431159 7
112233 3
456789 10
*/


/* 출력
#1 ㅇㄹ
*/
