//수열의 경우수
import java.util.*;
class Main{
	public int solution(int[] nums){
		int answer = 0;
		int n = nums.length;
		ArrayList<Integer> peaks = new ArrayList<>();

		for(int i=1; i<n; i++){
			if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
				peaks.add(i);
			}
		}

		for(int p : peaks){
			int left = p;
			int right = p;

			//바이토닉 조건을 만족해서 왼쪽으로 몇 번 움직였는지
			int lcnt = 0;
			//바이토닉 조건을 만족해서 오른쪽으로 몇 번 움직였는지
			int rcnt = 0;

			while(left-1 >= 0 && nums[left] > nums[left - 1]){
				lcnt++;
				left--;
			}

			while(right+1 < n && nums[right] > nums[right + 1]){
				rcnt++;
				right++;
			}
			//봉우리 인덱스가 1일 때는 1,3,2 로 lcnt: 1, rcnt: 1
			//봉우리 인덱스가 1일 때는 2,5,7,4,2 로 lcnt: 2, rcnt: 2
			//봉우리 인덱스가 1일 때는 2,5,1 로 lcnt: 1, rcnt: 1

			//lcnt*rcnt를 해주면 개수가 나온다.
			answer += lcnt*rcnt;
		}

		return answer;
	}
	public static void main (String[] args){
		Main T = new Main();
		int[] tmp1 = new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1};
		System.out.println(T.solution(tmp1));
	}
}
