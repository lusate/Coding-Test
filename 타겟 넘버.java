import java.util.*;
class Main {
	int answer=0; //target 값이 만들어지는 경우의 수
	public void DFS(int[] numbers, int target, int idx, int sum){
		//idx는 마지막 노드까지 탐색을 마쳤는지 체크 (즉 numbers.length 까지 다 마쳤는지)
		if(idx == numbers.length){
            if(sum == target) answer++; 
        }
		else{
            DFS(numbers, target, idx+1, sum+numbers[idx]);
            DFS(numbers, target, idx+1, sum-numbers[idx]);
        }   
    }
	public int solution(int[] numbers, int target) {
		DFS(numbers, target, 0, 0);
		return answer;
	}
		
	public static void main(String[] args){
		Main T = new Main();
		int[] numbers1 = new int[]{1,1,1,1,1};
		System.out.println(T.solution(numbers1, 3));
	}
}
