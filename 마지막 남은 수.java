import java.util.*;
class Main {
	public int solution(int[] nums){
		int answer = 0;
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

		for(int x : nums){
			pQ.offer(x);
		}
		//최대힙 만들고 x를 모두 넣어줌

		while(pQ.size() > 1){
			int a = pQ.poll();
			int b = pQ.poll();
			if(a != b) pQ.offer(Math.abs(a-b));
		}
		//사이즈가 1개가 될 때까지 a,b에서 꺼내준다
		//조건 a와 b가 다르면 a-b를 offer
		
		//pQ가 비어있지 않으면 answer = pQ.poll();
		if(!pQ.isEmpty()) answer = pQ.poll();
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[] arr1 = new int[]{5, 2, 4, 3, 1};
		System.out.println(T.solution(arr1));
		int[] arr2 = new int[]{7, 6, 3, 2, 4, 5, 1};
		System.out.println(T.solution(arr2));
	} 
}


//답
//1
//0
