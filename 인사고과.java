import java.util.*;
class Solution {
    //모든 사원들에 대한 인센티브 여부
    public boolean Incentive(int[] score, int[][] scores){
        for(int[] x : scores){
            if(x[0] > score[0] && x[1] > score[1]){
                return true;
            }
        }

        return false;
    }

    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanhoo = scores[0];
        int a = wanhoo[0];
        int b = wanhoo[1];
        int wanhooSum = a + b;

        for(int[] x : scores){
            int num1 = x[0];
            int num2 = x[1];
            int sum = num1 + num2;

            //완호가 인센티브를 받지 못하는 경우
            if(a < num1 && b < num2) return -1;

            if(sum > wanhooSum){
                //완호보다 합이 큰 사원들 중에 인센티브를 받을 수 있다면 랭크를 +
                if(!Incentive(x, scores)) answer++;
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
