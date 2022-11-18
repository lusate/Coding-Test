import java.util.*;
class Main {
	public ArrayList<Integer> solution(int[] nums){
		ArrayList<Integer> answer = new ArrayList<>();
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		//이렇게 하면 최대힙이 됨
		
		for(int x : nums){
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
class Main{
	//ps는 문제 점수, pt는 문제 타임
	public ArrayList<Integer> solution(int[] nums){
		ArrayList<Integer> answer = new ArrayList<>();
		PriorityQueue<Integer> pQ = new PriorityQueue<>();

		for(int x : nums){
			if(x == 0){
				if(pQ.isEmpty()) answer.add(-1);
				else answer.add(pQ.poll());
			}
			else{
				pQ.offer(x);
			}
		}

		System.out.println(answer);
		return answer;
	}
	public static void main(String args[]) throws Exception{
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++){
			nums[i] = sc.nextInt();
		}
		
		T.solution(nums);
	}
}
