import java.util.*;
class Solution{
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int cut = 0;
        for (int i = 0; i < targets.length; i++) {
            int lt = targets[i][0];
            int rt = targets[i][1];

            // lt가 자르려는 부분보다 작게 되먼 잘랐던 부분을 또 자르게 된다.
            // 그래서 lt가 cut보다 크게 해서 자르도록 해야 한다.
            if (lt >= cut) {
                answer++;
                cut = rt;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
    }
}


/* 출력
3
*/
