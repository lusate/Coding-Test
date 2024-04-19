import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    // 개수대로 짤라서 sum 구하기
    // num은 처음과 잘라낸 숫자의 합, countOdd(num) 한 홀수 개수
    static void divide(int num, int oddCnt) {
        if(num < 10) {
            MIN = Math.min(MIN,oddCnt);
            MAX = Math.max(MAX,oddCnt);
        }

        // 두자리
        else if(num < 100) {
            int sum = (num / 10) + (num % 10);
            divide(sum,oddCnt + countOdd(sum));
        }

        else {
            String str = Integer.toString(num);
            int len = str.length();
            for(int i = 0; i <= len-3; i++) {
                for(int j = i+1; j <= len-2; j++) {
                    String s1 = str.substring(0,i+1);
                    String s2 = str.substring(i+1,j+1);
                    String s3 = str.substring(j+1,len);
                    System.out.println(s1);
                    System.out.println(s2);
                    System.out.println(s3);

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);

                    // num이 한 자리가 될 경우까지 재귀 divide를 통해서 MAX, MIN을 뽑아낸다. 
                    divide(sum,oddCnt + countOdd(sum));
                }
            }
        }
    }

    // 한 번 계산 시 홀수가 몇 개인지 구하는 로직
    public static int countOdd(int num) {
        int cnt = 0;

        while (num > 0) {
            int cur = num % 10;
            if ((cur % 2) == 1) cnt++;
            num /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        divide(N,countOdd(N));
        System.out.printf("%d %d",MIN,MAX);
    }
}
