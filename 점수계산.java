package 인프런_입문.배열;

import java.util.*;
public class 점수계산 {
    public int solution(int n, int[] arr){
        int answer = 0;
        int score = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) { // 문제 맞춤
                score++;
                answer += score;
            } else score = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        점수계산 T = new 점수계산();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}
