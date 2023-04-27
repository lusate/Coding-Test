import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum < budget) {
                answer++;
            }
            if(sum == budget){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(T.solution(new int[]{2, 2, 3, 3}, 10));
    }
}

/* 출력
3
4
*/


// ---------------------------------------------------------------------------------------------

//다른 방법
import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            if (budget < 0) {
                break;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(T.solution(new int[]{2, 2, 3, 3}, 10));
    }
}

/* 출력
3
4
*/
