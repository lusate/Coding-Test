import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> list = new Stack<>(); //보조 컨테이너

        int cnt = 1; //현재 메인 컨테이너에 있는 박스는 1번
        // 순서대로 봄.
        for (int x : order) {
            // 1번부터 list에 넣을 것임.
            while (cnt <= order.length) { //다 넣을 때까지 반복
                if (cnt == x) { // 같은 번호를 넣으면 break
                    break;
                } else if (!list.isEmpty() && list.peek() == x) {
                    break; //list에 값이 있고 마지막 번호가 x와 같으면 break
                } else {
                    list.push(cnt); // 1번부터 차례대로 넣음
                    cnt++;
                }
            }

            if (cnt == x) { //컨테이너 벨트에서 순서에 맞는 택배 상자가 있으면 +.
                cnt++;
                answer++;
            } else if (!list.isEmpty() && list.peek() == x) { //보토 컨테이너에서 순서에 맞는 택배 상자가 있으면 +.
                list.pop(); //보조라면 빼줘야함.
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(T.solution(new int[]{5, 4, 3, 2, 1}));
    }
}


/* 출력
2
5
*/
