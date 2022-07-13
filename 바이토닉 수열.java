//바이토닉 수열
import java.util.*;
class Main{	
	public String solution(int[] nums){
		String answer = "YES";
		int n = nums.length;
		
		int i=0;
		//위치 i=1부터 증가시켜서 뒤 원소가 앞 원소보다 크다면
		//즉 값이 점점 커지는 구간
		while(i+1 < n && nums[i] < nums[i+1]){
			i++;
		}

		//마지막 원소까지 i++ 해서 계속 증가수열이 된다면 바이토닉이 될 수 없다.
		if(i == 0 || i == n-1){
			return "NO";
		}

		//위치 i=1부터 증가시켜서 뒤 원소가 앞 원소보다 작다면
		//즉 값이 점점 작아지는 구간
		while(i+1 < n && nums[i] > nums[i+1]){
			i++;
		}

		//i 가 n-1이 아니라면 즉 값이 작아지는데 마지막 원소까지 도달하지 않는다면 바이토닉이 될 수 없다.
		//
		if(i != n-1)
			return "NO";

		return answer;
	}
	public static void main (String[] args){
		Main T = new Main();
		int[] tmp1 = new int[]{1, 2, 3, 4, 5, 3, 1};
		System.out.println(T.solution(tmp1));
		
		int[] tmp2 = new int[]{1, 3, 4, 5, 5, 6, 4, 3};
		System.out.println(T.solution(tmp2));

		int[] tmp3 = new int[]{1, 2, 3, 4, 5};
		System.out.println(T.solution(tmp3));
	}
}
