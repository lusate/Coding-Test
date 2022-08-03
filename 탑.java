import java.util.*;
class Main {
	public int[] solution(int[] height){
		Stack<Integer> stack = new Stack<>();
		int n = height.length;
		int[] answer = new int[n];

		for(int i=n-1; i>=0; i--){
			while(!stack.empty() && height[i] > height[stack.peek()]){
				answer[stack.peek()] = i+1;
				stack.pop();
			}
			stack.push(i);
		}
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		int[] height1 = new int[]{6,9,5,7,4};
		for(int x : T.solution(height1)){
			System.out.print(x + " ");
		}
	}
}
