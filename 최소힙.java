import java.util.*;
class Main {
	public ArrayList<Integer> solution(int[] nums){
		ArrayList<Integer> answer = new ArrayList<>();
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		//PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		//이렇게 하면 최대힙이 됨
		
		for(int x : nums){
			//숫자 0이 입력되면 최소힙에서 최솟값을 꺼내어 출력.
			if(x == 0){//큐에서 하나 꺼냄
				if(pQ.isEmpty()) answer.add(-1); //큐가 비어있으면 -1
				else answer.add(pQ.poll());
			}
			else{ //0이 아니면
				pQ.offer(x);
			}
		}

		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		int[] arr = new int[]{5, 3, 6, 0, 5, 0, 2, 4, 0};
		System.out.println(T.solution(arr));
	} 
}
