import java.util.*;
class Main{
	public int count(int[] nums, int mid){
		int cnt = 0;

		//선 자름
		for(int x : nums){
			cnt += (x / mid);
		}

		return cnt;
	}
	public int solution(int[] nums, int n){
		int answer = 0;
		Arrays.sort(nums);

		int left = 0;
		int right = Arrays.stream(nums).max().getAsInt();

		while(left <= right){
			int mid = (left+right)/2;
			if(count(nums, mid) >= n){
				answer = mid;
				left = mid + 1;
			}
			else right = mid - 1;
		}



		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{802, 743, 457, 539}, 11));
		System.out.println(T.solution(new int[]{8593, 9617, 9313, 4513, 7505, 5457, 8257,
			4689, 2657}, 100));
	}
}


/* 출력
200
582
*/
