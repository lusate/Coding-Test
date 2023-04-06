//야근 지수
import java.util.*;
class Solution{
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int sum = 0; //소요 시간
        int ed = 0; //끝나는 시간
        int idx = 0; //인덱스
        int cnt = 0; // 작업 개수
        while(cnt < jobs.length){
            // 시작시간보다 끝나는 시간이 크면 추가가 불가능.
            // 그리고 현재 ed가 다음 시작 시간보다 크거나 같으면 계속 pq에 추가
            while(idx<jobs.length && jobs[idx][0] <= ed) {
                pq.add(new int[]{jobs[idx][0], jobs[idx][1]});
                idx++;
            }

            if(pq.isEmpty()){ // 다음 시작하는 시간이 이전 끝나는 시간보다 커서 pq가 비어있는 경우
                ed = jobs[idx][0];
            }
            else{
                int[] cur = pq.poll();

                sum += cur[1] + ed - cur[0];
                ed += cur[1]; //끝나는 시간 갱신.
                cnt++;
            }
        }
        answer = sum / jobs.length;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }
}
