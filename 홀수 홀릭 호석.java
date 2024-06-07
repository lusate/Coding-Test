import java.io.*;
import java.util.*;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    /**
     * 한 번 계산 시 홀수가 몇 개인지 구하는 로직
     */
    public static int countOdd(int num) {
        int cnt = 0;
        while (num > 0) {
            int now = num % 10;
            if (now % 2 == 1) {
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }

    /**
     * divide 하면서 홀수의 개수를 구해야 함
     * 개수대로 짤라서 sum 구하기
     * num은 처음과 잘라낸 숫자의 합, countOdd(num) 한 홀수 개수
     */
    public static void divide(int num, int oddCnt) {
        if (num < 10) {
            MIN = Math.min(MIN, oddCnt);
            MAX = Math.max(MAX, oddCnt);
        }
        // 각 자리의 숫자를 더하고 다시 divide
        else if (num < 100) {
            int sum = (num / 10) + (num % 10);
            divide(sum, oddCnt + countOdd(sum));
        }
        // 3자리 이상이면 임의로 divide
        else {
            String str = Integer.toString(num);
            int len = str.length();

            // 적어도 2개의 수는 남겨야하므로 len - 3
            // 그 다음 숫자는 1개의 수는 남겨야 하므로 len - 2
            for (int i = 0; i <= len - 3; i++) {
                for (int j = i + 1; j <= len - 2; j++) {
                    String s1 = str.substring(0, i + 1);
                    String s2 = str.substring(i + 1, j + 1);
                    String s3 = str.substring(j + 1, len);

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);

                    // 이전부터 현재 num까지의 홀수 개수를 더해서 최소/최대를 구하기 위해 oddCnt + countOdd를 함
                    divide(sum, oddCnt + countOdd(sum));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        divide(N,countOdd(N));
        System.out.printf("%d %d",MIN,MAX);
    }
}


/*
514
answer = 4 4

82019
answer = 4 5

999999999
answer = 11 18
*/
