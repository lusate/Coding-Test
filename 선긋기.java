import java.util.*;
class Main {
	public int solution(int[][] nums){
		int answer=0;
		Arrays.sort(nums, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]); //오름차순 정렬
		//시작점을 기준으로 오름차순 정렬을 하는데 시작점이 같은 경우는 끝점을 오름차순으로 정렬할 것이다.
		
		//앞에거 에서 뒤에거 빼면 오름차순 반대로 빼면 내림차순
		//즉 b[]-a[] 로 하는 경우
		//a[0]-b[0] : [0]을(시작점을) 기준으로 오름차순
		//a[1]-b[1] : [1]을(끝점을) 기준으로 오름차순
		
		int s = nums[0][0];
		int e = nums[0][1];
		for(int i=1; i<nums.length; i++){
			if(nums[i][0] <= e && nums[i][1] > e){
				e = nums[i][1];
			}
			else if(nums[i][0] > e){ //새롭게 시작임
				answer+=(e-s);
				s = nums[i][0];
				e = nums[i][1];
			}
		}

		//마지막 겹치지 않는 선의 길이도 더해야함.
		answer += (e-s);
		
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		System.out.println(T.solution(new int[][]{{1, 3}, {2, 5}, {7, 10}}));
		System.out.println(T.solution(new int[][]{{5, 6}, {1, 3}, {7, 8}, {9, 10}}));
	}
}
