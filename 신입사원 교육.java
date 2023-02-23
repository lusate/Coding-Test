import java.util.*;
class Solution {
    public int solution(int[] ability, int number) {
		int answer = 0; //최소합
        
        Arrays.sort(ability);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : ability){
            pq.add(x);
            answer += x;
        }
        for(int i=0; i<number; i++){
            int sum1 = pq.poll();
            int sum2 = pq.poll();
            pq.add(sum1 + sum2);
            pq.add(sum1 + sum2); //2개 합해서 삽입.
            
            answer += sum1 + sum2;
        }
        
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{10, 3, 7, 2}, 2));
		System.out.println(T.solution(new int[]{1, 2, 3, 4}, 3));
	}
}

/* 출력
37
26
*/
