import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int lt = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];
            while (sum > k && lt < rt) {
                sum -= sequence[lt];
                lt++;
            }

            if (sum == k) {
                if (rt - lt + 1 < min) { // 길이가 최소이면
                    min = rt - lt + 1;
                    answer[0] = lt;
                    answer[1] = rt;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 2, 2}, 6)));
    }
}

/* 출력
[2, 3]
[6, 6]
[0, 2]
*/
