package 인프런_입문.문자열;

import java.util.Scanner;

public class 가장_짧은_문자거리 {
    public int[] solution(String s, char t){
        int[] answer = new int[s.length()];
        int dis = 1000;

        // i가 0일 때 -> 가면서 e와 얼마나 떨어져있는지 찾음.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                dis = 0;
                answer[i] = dis;
            } else {
                dis++;
                answer[i] = dis;
            }
        }

        // i가 마지막 인덱스일 때 <- 가면서 e와 얼마나 떨어져있는지 찾음.
        dis = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                dis = 0;
            }else{
                dis++;
                answer[i] = Math.min(dis, answer[i]); // 그렇게 -> , <- 이동하면서 최솟값을 구함.
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        가장_짧은_문자거리 T = new 가장_짧은_문자거리();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for(int x : T.solution(str, c)){
            System.out.print(x+" ");
        }
    }
}
