import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int score = sc.nextInt(); //새로운 점수

        int P = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        if (N == P && arr[N - 1] >= score) {
            System.out.println(-1);
            System.exit(0);
        }

        int answer = 1; // 태수 등수
        for (int i = 0; i < N; i++) {
            if (arr[i] > score) {
                answer++;
            }
            else break;
        }
        System.out.println(answer);
    }
}

/* 입력
3 90 10
100 90 80

10 1 10
10 9 8 7 6 5 4 3 2 1

10 1 10
10 9 8 7 6 5 4 3 3 0
*/


/* 출력
2
-1
10
*/
