import java.util.*;
class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];

        int cnt = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = cnt++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < queries[i].length; j++) {
                queries[i][j]--;
            }
        }


        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int tmp = board[x1][y1];
            int min = Integer.MAX_VALUE;

            // 좌측 라인 회전
            for (int j = x1; j < x2; j++){
                min = Math.min(min, board[j][y1]);
                board[j][y1] = board[j + 1][y1];
            }

            // 하단 라인 회전
            for (int j = y1; j < y2; j++) {
                min = Math.min(min, board[x2][j]);
                board[x2][j] = board[x2][j + 1];
            }

            // 우측 라인 회전
            for (int j = x2; j > x1; j--) {
                min = Math.min(min, board[j][y2]);
                board[j][y2] = board[j - 1][y2];
            }

            // 윗 라인 회전
            for (int j = y2; j > y1; j--) {
                min = Math.min(min, board[x1][j]);
                board[x1][j] = board[x1][j - 1];
            }

            board[x1][y1 + 1] = tmp;
            answer[i] = min;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 6, new int[][]{{2,2,5,4}, {3,3,6,6}, {5,1,6,3}})));
        System.out.println(Arrays.toString(T.solution(3, 3, new int[][]{{1,1,2,2}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}})));
        System.out.println(Arrays.toString(T.solution(100, 97, new int[][]{{1,1,100,97}})));
    }
}

/* 출력
[8, 10, 25]
[1, 1, 5, 3]
[1]
*/
