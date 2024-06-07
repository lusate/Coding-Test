package 프로그래머스문제;

import java.util.Arrays;

public class 쿼드압축 {
    static int[] answer;

    /**
     * 주어진 정사각형에서 정확히 4개의 균일한 정사각형 영역으로 쪼갬
     * 나눈 정사각형에서 모든 값이 같은지 다른지에 대한 여부 필요
     */
    public boolean check(int[][] arr, int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 분할 정복이라고 함. 이러한 문제들 몇 번 시험에서 본 적이 있으니 기억하자.
     */
    public void divide(int[][] arr, int x, int y, int size) {
        if (check(arr, x, y, size, arr[x][y])) {
            if(arr[x][y] == 1) answer[1]++;
            else answer[0]++;
            return; // return 하지 않으면 계속 재귀를 하게 되므로 overflow 발생
        }
        divide(arr, x, y, size/2);
        divide(arr, x + size / 2, y, size / 2);
        divide(arr, x, y + size / 2, size / 2);
        divide(arr, x + size / 2, y + size / 2, size / 2);
    }
    public int[] solution(int[][] arr) {
        answer = new int[2];
        divide(arr, 0, 0, arr.length);
        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }
    public static void main(String[] args) {
        쿼드압축 T = new 쿼드압축();
        System.out.println(
                Arrays.toString(T.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
//        System.out.println(T.solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},
//                {0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}}));
    }
}

/*
[4, 9]
[10, 15]
 */
