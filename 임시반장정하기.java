package 인프런_입문.배열;

import java.util.*;
public class 임시반장정하기 {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) { // i와 j는 학생 번호
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) { // 학년
                    if (arr[i][k] == arr[j][k]) {
                        cnt++; // 반이 같음
                        break; // k 학년일 때 수를 세는 것이 아닌 학생 수를 세는 것이므로 break 해야 한다.
                    }
                }
            }

            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        임시반장정하기 T = new 임시반장정하기();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[][] arr=new int[n+1][6];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=5; j++){
                arr[i][j]=kb.nextInt();
            }
        }
        System.out.print(T.solution(n, arr));
    }
}
