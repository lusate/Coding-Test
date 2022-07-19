import java.util.*;
class Main{
	public int solution(int[] apples, int[] power, int m){
		int answer = 0;
		int sum = 0;
		int left = 0;

		for(int right=0; right<apples.length; right++){
			if(power[right] == 1){
				sum += apples[right];
			}
		}
		for(int right=0; right<m; right++){
			//연속된 m은 무조건 점프를 해서 사과를 딸 수 있음.
			if(power[right] == 0){
				sum += apples[right];
			}
		}

		answer = sum;
		for(int right=m; right<apples.length; right++){
			if(power[right] == 0){
				sum += apples[right];
			}

			if(power[right-m] == 0) sum -= apples[right-m];
			left++;
			answer = Math.max(answer, sum);
		}

		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[] arr1 = new int[]{3, 2, 1, 2, 1, 3};
		int[] arr2 = new int[]{1, 0, 0, 1, 0, 0};
		System.out.println(T.solution(arr1, arr2, 3));

		int[] arr3 = new int[]{3, 2, 3,2,1,3};
		int[] arr4 = new int[]{1, 0,0,1,0,0};
		System.out.println(T.solution(arr3, arr4, 3));
	}
}
