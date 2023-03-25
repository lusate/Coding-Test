//범위가 나오면 항상 그리디 문제
import java.util.*;
class Solution{
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] line = new int[nums.length+1][2];
        for (int i = 0; i <= n; i++) {
            line[i][0] = Math.max(0, i - nums[i]);
            line[i][1] = Math.min(n, i + nums[i]);
        }
        // 시작점 기준으로 정렬해야 순서대로 정렬이 됨.
        Arrays.sort(line, (a, b) -> a[0] - b[0]);
        /**
         * line
         * [0,1] [0, 2], [1, 3], [1, 5], [3, 5], [4, 6], [4 ,8], [6, 8], [7, 8]
         */

        int st = 0, ed = 0;
        int i = 0;
        while (i < line.length) {
            // start지점부터 가장 길게 물을 뿌릴 수 있는 스프링쿨러 찾는 로직.
            while (i < line.length && line[i][0] <= st) {
                ed = Math.max(ed, line[i][1]);
                i++;
            }

            answer++; //스프링쿨러 찾으면 +1;
            if(ed == n) return answer; // 마지막까지 다 스프링쿨러를 뿌렸으므로 끝냄
            if(st == ed) return -1; // 물 뿌릴 수 없음. line[i][0] <= st 이게 거짓임.
            //뿌릴 수 없으므로 start와 end가 같은 값으로 있게 됨.
            st = ed;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}


/* 출력
3
1
-1
3
*/
