//최대 길이 바이토닉, 바이토닉 수열 중요
//봉우리를 찾는 것이 중요
import java.util.*;
class Main{
	public int solution(int[] nums){
		int answer = 0;
		
		int n = nums.length;
		ArrayList<Integer> peaks = new ArrayList<>();

		//봉우리는 왼쪽 값보다 크고 오른쪽 값보다 커야한다.
		//봉우리 값이 아닌 인덱스를 찾음
		for(int i=1; i<n-1; i++){
			if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
				peaks.add(i);
			}
		}

		for(int p : peaks){
			//p는 봉우리 봉우리 인덱스임
			int left = p;
			int right = p;
			//System.out.println(p); 붕우리 인덱스 1,4,7
			int cnt = 1;

			//봉우리인덱스-1 은 0보다 크거나 같고 봉우리값이 왼쪽 값보다 크면
			while(left-1 >= 0 && nums[left-1] < nums[left]){
				cnt++;
				left--;
				//System.out.println("cnt1: " + cnt);
				//System.out.println("left: " + left);
			}
			while(right+1 < n && nums[right+1] < nums[right]){
				cnt++;
				right++;
				//System.out.println("cnt2: " + cnt);
				//System.out.println("right: " + right);
			}

			//cnt에는 모든 바이토닉 수열의 길이가 저장되어있음
			answer = Math.max(answer ,cnt);
		}
		return answer;
	}
	public static void main (String[] args){
		Main T = new Main();
		int[] tmp1 = new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1};
		System.out.println(T.solution(tmp1));
	}
}
