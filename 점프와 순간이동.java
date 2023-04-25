import java.util.*;
class Solution{
    public int solution(int n) {
        int answer = 0;

        // 처음에는 k 점프를 n만큼 줘서 for문 돌렸더니 시간 초과.
        // 그래서 거꾸로 생각해서 n에서 빼주는 방식으로 수정.
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else{
                n -= 1;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(5));
        System.out.println(T.solution(6));
        System.out.println(T.solution(5000));
    }
}


/* 출력
2
2
5
*/
