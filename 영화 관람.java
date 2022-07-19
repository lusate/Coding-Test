import java.util.*;
class Main{
	public int[] solution(int[] nums){
		Stack<Integer> stack = new Stack<>();
		int n = nums.length;
		int[] answer = new int[n]; // answer 가 0을 초기화

		//여기 중요
		for(int i=n-1; i>=0; i--){
			//매우 중요
			while(!stack.empty() && nums[i] > nums[stack.peek()]){ //방해자 발견
				answer[stack.peek()] = i+1; //번호를 찾아줌 (인덱스 + 1)
				stack.pop();
			}
			stack.push(i);
		}
		
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[] arr = new int[]{50, 46, 55, 76, 65, 50, 55, 53, 55, 50};
		//System.out.println(T.solution(arr));
		for(int x : T.solution(arr)){
			System.out.print(x+" ");
		}
	}
}
