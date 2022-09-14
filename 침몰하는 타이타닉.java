import java.util.*;
class Main{
	public int solution(int[] nums, int m){
		int answer=0;  //보트 개수
		int left=0;
		int right=nums.length-1;

		Arrays.sort(nums);
		//양쪽에서 2개를 비교
		while(left <= right){
			if(nums[left] + nums[right] <= m){
				answer++; //보트 수 추가
				left++;
				right--;
			}
			else{//m보다 커져도 보트 수 하나가 필요
				answer++;
				right--;
			}
		}
		
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
		System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
	}
}


//답
//3
//5
