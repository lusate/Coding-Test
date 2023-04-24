import java.util.*;
class Solution {
    public long gcd(int a, int b) {
        if(a == 0) return b;

        return gcd(b % a, a);
    }
    public long solution(int w, int h) {
        long answer = 1;
        long a = Long.valueOf(w);
        long b = Long.valueOf(h);

        answer = a * b - (a + b - gcd(w, h)); // 최대공약수를 빼준다.
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(8, 12));
        System.out.println(T.solution(1, 8));
    }
}

/* 출력
80
0
*/
