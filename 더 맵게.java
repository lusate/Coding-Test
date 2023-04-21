import java.util.*;

class Solution{
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int x : scoville) {
            pq.add(x);
        }

        while(pq.peek() < K){
            if (pq.size() == 1) { // pq에 모두 삽입을 했는데 그냥 사이즈가 바로 1일 수 있으므로 if문은 맨 앞에 위치해야 한다.
                return -1;
            }

            int now = pq.poll();
            int next = pq.poll();

            int value = now + (next * 2);
            pq.add(value);
            answer++;
        }

        return answer;
    }


    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(T.solution(new int[]{2}, 3));
    }
}

/* 출력
2
-1
*/
