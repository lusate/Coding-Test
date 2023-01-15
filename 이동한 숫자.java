import java.util.*;
class Data {
	//원래 숫자 num, 원래 인덱스 idx, 왼쪽에 큰 값들이 몇개 있는지 big
	public int num, idx, big;
	Data(int num, int idx, int big){
		this.num = num;
		this.idx = idx;
		this.big = big;
	}
}
class Solution {
	Data[] a, b;
	public void divide(int left, int right){
		if(left < right){
			int mid = (left + right) / 2;
			divide(left, mid);
			divide(mid + 1, right);
			int p1 = left;
			int p2 = mid + 1;
			int p3 = left;
			while(p1 <= mid && p2 <= right){
				if(a[p1].num <= a[p2].num) b[p3++] = a[p1++];
				else{
					b[p3] = a[p2++];
					b[p3++].big += (mid - p1 + 1); //개수 세기
				}
			}
			while(p1 <= mid) b[p3++] = a[p1++];
			while(p2 <= right) b[p3++] = a[p2++];
			for(int i = left; i <= right; i++){
				a[i] = b[i];
			}
		}
	}
	public int[] solution(int[] nums){
		int n = nums.length;
		a = new Data[n];
		b = new Data[n];
		for(int i = 0; i < n; i++){
			a[i] = new Data(nums[i], i, 0);
		}
		divide(0, n-1);
		int[] answer = new int[n - 1];
		for(int i = 0; i < n; i++){
			if(a[i].idx == 0) continue; //i가 1일 때부터 시작이므로 0은 넘어감.
			answer[a[i].idx - 1] = a[i].big; //i 1부터 이동 시작. answer[0] 부터
		}
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[]{5,4,2,1,3})));	
		System.out.println(Arrays.toString(T.solution(new int[]{6, 5, 8, 4, 2, 7, 1, 3})));	
		System.out.println(Arrays.toString(T.solution(new int[]{3, 2, 7, 9, 1, 5, 6, 8, 7})));	
	}
}



/* 출력
[1, 2, 3, 2]
[1, 0, 3, 4, 1, 6, 5]
[1, 0, 0, 4, 2, 2, 1, 2]
*/
