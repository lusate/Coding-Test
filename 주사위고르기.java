package 프로그래머스;

import java.util.*;

public class 주사위고르기 {
    static int n;
    static ArrayList<Integer> arrA;
    static ArrayList<Integer> arrB;
    public void dfs(int L, int start) { // A가 이길 수 있는 경우의 수
        if (L == n / 2) { // A가 n/2개 선택했을 때

        }

        for (int i = start; i < n; i++) {
            dfs(L + 1, i + 1);
        }
    }
    public int[] solution(int[][] dice) {
        n = dice.length;
        int[] answer = new int[n / 2];


        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args) {
        주사위고르기 T = new 주사위고르기();
        System.out.println(T.solution(new int[][]{{1,2,3,4,5,6}, {3,3,3,3,4,4}, {1,3,3,4,4,4}, {1,1,4,4,5,5}}));
        System.out.println(T.solution(new int[][]{{1,2,3,4,5,6}, {2,2,4,4,6,6}}));
        System.out.println(T.solution(new int[][]{{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}}));
    }
}


/*
(1) n / 2개의 주사위를 선택하는 조합을 구한다.
(2) A의 주사위로 얻을 수 있는 점수를 구한다.
(3) B의 주사위로 얻을 수 있는 점수를 구한다.
(4) A의 몇 번 이기는지 구한다.
(5) 현재 주사위 번호가 0부터 시작하기 때문에 1씩 더해준다.
(6) n / 2개의 주사위를 모두 골랐을 경우 주사위 번호 조합을 리스트에 추가한다.
(7) B가 가져간 나머지 n / 2개의 주사위 번호를 가져온다.
(8) A가 가져간 주사위 번호를 true 처리한다.
(9) n / 2개의 주사위를 모두 굴렸을 경우 나오는 점수를 리스트에 추가한다.
(10) 이분 탐색하여 A의 점수로 이길 수 있는 B의 점수의 개수를 구한다.
 */
