package 인프런_입문.문자열;

import java.util.Scanner;

public class 가장_짧은_문자거리 {
    public int[] solution(String s, char t){
        int[] answer = new int[s.length()];
        int dis = 1000;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                dis = 0;
                answer[i] = dis;
            } else {
                dis++;
                answer[i] = dis;
            }
        }

        dis = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                dis = 0;
            }else{
                dis++;
                answer[i] = Math.min(dis, answer[i]);
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
