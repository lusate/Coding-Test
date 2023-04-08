import java.util.*;
class Solution{
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, String> group = new HashMap<>();  // 조직에 참여해준 사람 짝꿍.
        HashMap<String, Integer> map = new HashMap<>(); // 판매원 이름들의 각 판매 금액

        for (int i = 0; i < enroll.length; i++) {
            group.put(enroll[i], referral[i]);
            map.put(enroll[i], i); //i는 인덱스 번호대로 answer에 저장하기 위함.
        }

        for (int i = 0; i < seller.length; i++) {
            String now = seller[i];
            int profit = 100 * amount[i]; //seller들의 각 이익.

            while (!now.equals("-")) {// "-" 가 아니라는 것은 다단계 조직에 참여시킨 다른 판매원의 이름이 있다는 것
                int nextProfit = profit / 10;
                int curProfit = profit - nextProfit;

                answer[map.get(now)] += curProfit;

                now = group.get(now);
                profit /= 10;

                if (profit < 1) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10})));

        System.out.println(Arrays.toString(T.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"}, new int[]{2, 3, 5, 4})));
    }
}

/* 출력
[360, 958, 108, 0, 450, 18, 180, 1080]
[0, 110, 378, 180, 270, 450, 0, 0]
*/
