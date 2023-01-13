import java.util.*;
class Solution{
	//복사할 빈 배열 필요
	static int[] tmp = new int[10];
	private static void divide(int lt, int rt, int[] nums){
		if(lt < rt){
			int mid = (lt+rt) / 2;
			divide(lt, mid, nums);
			divide(mid+1, rt, nums);
			//여기까지는 자식들이 이미 정렬이 되어 있음.

			//다 분할하고나서 이제 병합
			int p1 = lt;
			int p2 = mid+1;
			int p3 = lt;
			while(p1 <= mid && p2 <= rt){
				if(nums[p1] <= nums[p2]) tmp[p3++] = nums[p1++];
				else tmp[p3++] = nums[p2++];
			}
			
			while(p1 <= mid){ //p1이 남아있으면
				tmp[p3++] = nums[p1++];
			}

			while(p2 <= rt){
				tmp[p3++] = nums[p2++];
			}

			//정렬해줄 때 이제 tmp를 nums로 복사
			for(int i=lt; i<=rt; i++){
				nums[i] = tmp[i];
			}
		}

	}
	private static int[] solution(int[] nums) {
		int n = nums.length;
		int[] answer = new int[n];
		divide(0, n-1, nums);

		for(int i=0; i<n; i++) System.out.print(nums[i] + " ");
		
		return answer;
	}
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new int[]{6,5,8,4,2,7,1,3})));
	}
}
