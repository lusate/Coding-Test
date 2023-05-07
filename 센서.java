import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dir = new int[N];
        for (int i = 0; i < N; i++) {
            dir[i] = sc.nextInt();
        }
        Arrays.sort(dir);

        int answer = 0;
        Integer[] res = new Integer[N-1]; //두 값의 차이를 넣는 배열
        for (int i = 0; i < N - 1; i++) {
            res[i] = dir[i + 1] - dir[i];
            // 2 3 0 1 2
        }
        Arrays.sort(res, Collections.reverseOrder());

        for (int i = K - 1; i < N - 1; i++) {
            answer += res[i];
        }
        System.out.println(answer);
    }
}


/* 입력
6
2
1 6 9 3 6 7


10
5
20 3 14 6 7 8 18 10 12 15
*/

/* 출력
5
7
*/
