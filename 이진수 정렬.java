import java.util.*;
class Solution{
	public int[] solution(int[] nums){
		int[] answer = new int[nums.length];
		int[][] res = new int[nums.length][2];

		//이진수로 바꾸기
		for(int i=0; i<nums.length; i++){
			int cnt = 0; //1 개수
			int tmp = nums[i];

			while(tmp > 0){ //이진수에서 1의 개수를 구함.
				cnt += tmp % 2;
				tmp = tmp/2;
			}


			res[i][0] = cnt; //1의 개수
			res[i][1] = nums[i]; //처음 nums[]
		}
    
    //1의 개수가 같은 것이 있으면 십진수가 작은 것을 기준으로 정렬해야 함.
		Arrays.sort(res, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		
		for(int i=0; i<res.length; i++){
			answer[i] = res[i][1];
		}
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
        	System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        	System.out.println(Arrays.toString(T.solution(new int[]{5,4,3,2,1})));
        	System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
	}
}


/* 출력
[8, 5, 6, 9, 7]
[1, 2, 4, 3, 5]
[5, 12, 17, 7, 21, 23, 45]
*/
