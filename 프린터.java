import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }

        int idx = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            boolean flag = false;
            for (int[] x : q) { //q에 있는 모든 값을 대상으로 비교해서 q에 삽입해야 함.
                if (x[1] > now[1]) {
                    flag = true;
                }
            }
            if(flag) q.add(new int[]{now[0], now[1]});
            else{
                idx++;
                if (now[0] == location) {
                    answer = idx;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(T.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}


/* 출력
1
5
*/


// ------------------------------------------------------------------------------------------


import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        System.out.println(pq);

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }

                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(T.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
