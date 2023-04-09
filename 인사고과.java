import java.util.*;
class Solution {
    //모든 사원들에 대한 인센티브 여부
    public boolean Incentive(int[] score, int[][] scores){
        for(int[] x : scores){ //x는 모든 사원.
            //현 사원의 점수가 다른 사원들보다 둘다 작다면 인센티브 받지 못함.
            if(score[0] < x[0] && score[1] < x[1]){
                return false;
            }
        }
        return true;
    }

    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanhoo = scores[0];
        int a = wanhoo[0];
        int b = wanhoo[1];
        int wanhooSum = a + b;

        for(int[] x : scores){
            int sum = x[0] + x[1];

            //완호가 인센티브를 받지 못하는 경우
            if(a < x[0] && b < x[1]) return -1;

            if(sum > wanhooSum){
                //완호보다 합이 큰 사원들 중에 인센티브를 받을 수 있다면 랭크를 +
                //완호보다 점수 합이 작다면 랭크를 셀 필요가 없음.
                if(Incentive(x, scores)) answer++;
                // 이렇게 2차원 배열에서 하나를 선택해서 모두와 비교할 때는 파라미터로
                // 1차원 배열짜리 하나 추가하여 풀어보기.
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
        System.out.println(T.solution(new int[][]{{2, 1}, {2, 2}, {3, 2}, {4, 2}, {2, 1}}));
    }
}

/* 출력
4
-1
*/
