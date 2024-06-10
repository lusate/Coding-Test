import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int sum = 0;
        int[] board = new int[N + 1];
        /**
         * 전체 거리를 어떻게 구하라는 건지 이해가 안 감.
         * 여전히 sum을 왜 저렇게 구해야 하는 건지 모르겠음.
         * sum은 모든 탑 간의 거리의 전체 합.
         */
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            board[i] = n;
            sum += n; // 15
        }

        int lt = 0;
        int rt = 0;
        int result = 0;
        int now = board[lt];

        /**
         * 원형이기 때문에 시계방향일 때 now가 1이면 반시계는 now 가 14다.
         * now = 2 => 반시계 = 13
         * now = 5 => 반시계 = 10
         */
        while (lt <= rt && rt < N) {
            int minNow = Integer.min(now, sum - now);
            result = Integer.max(result, minNow);

            /**
             * 두 지점 사이의 거리인 now는 계속 늘려나가야 함.
             * 늘려나가는 건 board로 늘려나감
             * 근데 minNow로 같아버리면 now는 최소값이 되는 것이므로 같다면 board로 거리를 늘려야 함.
             */
            if (now == minNow) {
                rt++;
                now += board[rt];
            }
            else{
                now -= board[lt];
                lt++;
            }
        }
        System.out.println(result);
    }
}

/*
5
1
2
3
4
5
 */
