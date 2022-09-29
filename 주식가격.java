import java.util.*;
public class Main {
	public int[] solution(int[] prices) {
		int n = prices.length;
		Stack<Integer> stack = new Stack<>();

        int[] answer = new int[n];

		for(int i=0; i<n; i++){
			while(!stack.empty() && prices[i] < prices[stack.peek()]){
				answer[stack.peek()] = i-stack.peek();
				stack.pop();
			}
			stack.push(i); //인덱스를 집어넣음.
		}

		while(!stack.empty()){
			answer[stack.peek()] = n - stack.peek() - 1;
			stack.pop();
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[] prices = new int[]{1,2,3,2,3};
		for(int x : T.solution(prices)){
			System.out.print(x + " ");
		}
	}
}
