package main;
import java.util.*;

public class Solution {

    // 숫자 k 10진수를 n진법으로 바꾸는 로직
    public String convert(int k, int n) {
        String result = "";
        if (k == 0) {
            return "0";
        }

        while (k > 0) {
            int a = k / n;
            int b = k % n;

            if (b > 9) {
                result = (char) (b + 55) + result; // 10이라고 하면 55를 더해서 A가 나오도록 함
            } else {
                result = b + result;
            }

            k = a;
        }
        return result;
    }
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int num = 0; // n진수 할 숫자 (0부터 시작)
        int cnt = 0; // total까지의 숫자만 꺼내야함. 그래서 convert한 결과값의 길이
        int total = (t - 1) * m + p;

        String tmp = ""; // n진수 했을 때 전체 출력
        while(cnt < total){
            String str = convert(num, n);

            for (int i = 0; i < str.length(); i++) {
                tmp += str.charAt(i);
                cnt++;
            }
            num++;
        }

        for (int i = p-1; i < tmp.length(); i += m) {
            answer += tmp.charAt(i);
        }

        return answer.substring(0, t);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(2, 4, 2, 1));
        System.out.println(T.solution(16, 16, 2, 1));
        System.out.println(T.solution(16, 16, 2, 2));
    }
}
