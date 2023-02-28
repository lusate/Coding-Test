import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> Q1 = new LinkedList<>();
        Queue<Integer> Q2 = new LinkedList<>();
        for(int x : queue1){
            Q1.add(x);
            sum1 += x;
        }
        for(int x : queue2){
            Q2.add(x);
            sum2 += x;
        }
        
        // if((sum1 + sum2) % 2 == 1) return -1; 없어도 통과는 함
        long result = (sum1 + sum2) / 2;
		while(sum1 != sum2){
			if(sum1 > result){
				sum1 -= Q1.peek();
				sum2 += Q1.peek();
				Q2.add(Q1.poll());
			}
			else{
				sum2 -= Q2.peek();
				sum1 += Q2.peek();
				Q1.add(Q2.poll());
			}

			answer++;
			//Q1에서 Q2, Q2에서 Q1으로 모두 자리바꿈해서 Q1 모든 원소들이 다시 Q1을 올아오는 횟수
			if(answer > (queue1.length + queue2.length) * 2) return -1;
		}
		
        return answer;
    }

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
		System.out.println(T.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
		System.out.println(T.solution(new int[]{1, 1}, new int[]{1, 5}));
	}
}


/* 출력
2
7
-1
*/
