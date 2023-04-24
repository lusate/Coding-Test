import java.util.*;
class Solution {
    public long gcd(int a, int b) {
        long small = 0;
        long big = 0;

        if (a < b) {
            big = b;
            small = a;
        }

        long tmp = 0;
        while (small > 0) {
            tmp = big % small;
            big = small;
            small = tmp;
        }

        return big;
    }
    public long solution(int w, int h) {
        long answer = 1;

        answer = (long) (w * h) - (long)(w + h - gcd(w, h)); //최대 공약수를 구해서 빼준다.
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
