import java.util.*;
class Solution{
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int AIdx = 0;
        int BIdx = 0;
        while (AIdx < A.length && BIdx < B.length) {
            if (A[AIdx] < B[BIdx]) {
                answer++;
                AIdx++;
            }
            BIdx++;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{5, 1, 3, 7},
                new int[]{2, 2, 6, 8}));
        System.out.println(T.solution(new int[]{2, 2, 2, 2},
                new int[]{1, 1, 1, 1}));
    }
}


/* 출력
3
0
*/
